FROM openjdk:11
ADD ./target/product-service-0.0.1-SNAPSHOT.jar /event/src/product-service-0.0.1-SNAPSHOT.jar
ADD ./assets/ProductSeeddataSheet.csv /event/src/assets/ProductSeeddataSheet.csv
EXPOSE 8084
WORKDIR event/src
ENTRYPOINT ["java","-jar","product-service-0.0.1-SNAPSHOT.jar"]