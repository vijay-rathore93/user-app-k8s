# Use an official Maven image as a build environment
FROM maven:3.8.4-openjdk AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and source code to the container
COPY pom.xml .
COPY src/ ./src/

# Build the Maven project
RUN mvn clean package -DskipTests

# Create a new image based on a lightweight OpenJDK JRE image
FROM openjdk
LABEL MAINTAINER="vijay-rathor,email:rathorvijay529@gmail.com"
# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR from the build environment to the container
COPY --from=build /app/target/user-app-0.0.1-SNAPSHOT.jar .

# Expose the port that the Spring Boot app listens on
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "user-app-0.0.1-SNAPSHOT.jar"]