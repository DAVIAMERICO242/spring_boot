# O FROM inicia um novo "container" (intermediario), esse container buildara o projeto
FROM maven:3.8.4-openjdk-17 AS build

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo pom.xml e os arquivos de dependências
COPY pom.xml .
COPY src ./src

# Compila e empacota a aplicação
RUN mvn clean package -DskipTests

# O container abaixo pegara o projeto buildado do outro container e o executara baseado no java 17
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho dentro do contêiner ATUAL
WORKDIR /app

# Copia o jar do container anterior para esse conteiner
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta 8888
EXPOSE 8888

# Define o comando de inicialização do contêiner
CMD ["java", "-jar", "app.jar"]
