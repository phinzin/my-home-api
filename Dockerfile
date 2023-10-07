# FROM eclipse-temurin:17-jdk-jammy as builder
FROM maven:3.9.4-eclipse-temurin-17 as builder
WORKDIR /opt/app
COPY .mvn/ .mvn
# COPY mvnw pom.xml ./
COPY pom.xml ./
# RUN ./mvnw dependency:go-offline
COPY ./src ./src
# RUN ./mvnw clean install
 RUN mvn clean install
 
FROM eclipse-temurin:17-jre-jammy
WORKDIR /opt/app
EXPOSE 8080
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar
ENTRYPOINT ["java", "-jar", "/opt/app/*.jar" ]
 
