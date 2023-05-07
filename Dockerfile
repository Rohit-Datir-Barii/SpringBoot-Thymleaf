FROM openjdk:8
EXPOSE 4042
ADD target/springbootapp.jar springbootapp.jar
ENTRYPOINT ["java","-jar","springbootapp.jar"]