FROM openjdk:11
ADD ./target/recommendation-service-0.0.1-SNAPSHOT.jar /event/src/recommendation-service-0.0.1-SNAPSHOT.jar
WORKDIR event/src
ENTRYPOINT ["java","-jar","recommendation-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 8083