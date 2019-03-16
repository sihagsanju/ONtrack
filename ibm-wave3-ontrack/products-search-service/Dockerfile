FROM openjdk:11
ADD ./target/products-search-service-0.0.1-SNAPSHOT.jar /event/src/products-search-service-0.0.1-SNAPSHOT.jar
WORKDIR event/src
ENTRYPOINT ["java","-jar","products-search-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 8013
