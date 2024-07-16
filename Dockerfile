# Use a imagem oficial do Maven para compilar e empacotar a aplicação
FROM maven:3.8.4-openjdk-17 AS build

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo pom.xml e os arquivos de dependências
COPY pom.xml .
COPY src ./src

# Compila e empacota a aplicação
RUN mvn clean package -DskipTests

# Usa uma imagem base menor para o JDK 17
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o jar do estágio anterior
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta 8888
EXPOSE 8888

# Define o comando de inicialização do contêiner
CMD ["java", "-jar", "app.jar"]
