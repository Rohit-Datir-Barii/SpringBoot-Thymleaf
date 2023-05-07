FROM openjdk:8
EXPOSE 8080
ADD target/springbootapp.jar springbootapp.jar
ENTRYPOINT ["java","-jar","springbootapp.jar"]