FROM openjdk:21
EXPOSE 8080
ADD target/docker-test.jar docker-test.jar
ENTRYPOINT ["java","-jar","/docker-test.jar"]