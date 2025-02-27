package org.example.api.auth;
import jakarta.validation.Valid;
import org.example.api.auth.DTOS.AuthenticationDTO;
import org.example.api.auth.DTOS.LoginResponseDTO;
import org.example.api.auth.DTOS.RegisterDTO;
import org.example.api.auth.services.TokenService;
import org.example.api.user.User;
import org.example.api.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        try {
            var auth = this.authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((User) auth.getPrincipal());

            return ResponseEntity.ok(new LoginResponseDTO(token));
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(401).body(e);
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.repository.findByUsername(data.username()) != null) return ResponseEntity.badRequest().body("User already exists");

        try{
            String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
            User newUser = new User(data.username(), encryptedPassword, data.role());

            this.repository.save(newUser);

            return ResponseEntity.ok().body(newUser);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/change_user")
    public ResponseEntity edit(@RequestBody @Valid RegisterDTO data){
        try{
            String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
            this.repository.save(new User(data.username(),encryptedPassword,data.role()));
            return ResponseEntity.ok().body((new User(data.username(),encryptedPassword,data.role())));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e);
        }

    }

}