FROM openjdk:11
VOLUME /tmp
EXPOSE 8761
ADD ./target/hr-eurekaserver-0.0.1-SNAPSHOT.jar hr-eurekaserver.jar
ENTRYPOINT ["java","-jar","/hr-eurekaserver.jar"]