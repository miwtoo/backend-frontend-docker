FROM openjdk:8-jdk-slim
COPY ./target/app-0.0.1-SNAPSHOT.jar /opt/app.jar
WORKDIR /opt
CMD ["java", "-jar", "/opt/app.jar"]