FROM java:8
EXPOSE 8080:8080
ADD /target/spring-boot-h2-hibernate-docker.jar spring-boot-h2-hibernate-docker.jar
ENTRYPOINT ["java","-jar","spring-boot-h2-hibernate-docker.jar"]