FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

# dá permissão de execução ao mvnw
RUN chmod +x mvnw

RUN ./mvnw clean package

EXPOSE 8080

CMD ["java", "-jar", "target/crud-0.0.1-SNAPSHOT.jar"]