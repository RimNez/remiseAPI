FROM openjdk:8
EXPOSE 8081
ADD target/remise-API.jar remise-API.jar
ENTRYPOINT ["java","-jar","remise-API.jar"]