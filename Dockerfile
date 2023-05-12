FROM openjdk:17.0.2-slim-buster
ADD . /src
WORKDIR /src
RUN ./mvnw package -DskipTests
EXPOSE 8080
ENTRYPOINT ["java","-jar","target/jopka-0.0.1-SNAPSHOT.jar"]