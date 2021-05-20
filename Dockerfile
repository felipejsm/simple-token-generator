FROM adoptopenjdk/openjdk11:ubi
EXPOSE 8080
COPY target/*.jar token.jar
ENTRYPOINT ["java","-jar","token.jar"]