FROM openjdk:8
EXPOSE 9090
ADD target/springbootapp.jar springbootapp.jar
ENTRYPOINT ["java","-jar","springbootapp.jar"]