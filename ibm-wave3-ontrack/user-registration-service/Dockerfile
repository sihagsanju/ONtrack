FROM openjdk:11
ADD ./target/user-registration-service-0.0.1-SNAPSHOT.jar /event/src/user-registration-service-0.0.1-SNAPSHOT.jar
WORKDIR event/src
ENTRYPOINT ["java","-jar","user-registration-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 8015