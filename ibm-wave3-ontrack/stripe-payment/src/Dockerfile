FROM openjdk:11
ADD ./target/stripe-payment-0.0.1-SNAPSHOT.jar /event/src/stripe-payment-0.0.1-SNAPSHOT.jar
EXPOSE 8014
WORKDIR event/src
ENTRYPOINT ["java","-jar","stripe-payment-0.0.1-SNAPSHOT.jar"]