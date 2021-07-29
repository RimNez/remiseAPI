FROM openjdk:8
EXPOSE 8080
ADD target/remise-API.jar remise-API.jar
ENTRYPOINT ["java","-jar","remise-API.jar"]