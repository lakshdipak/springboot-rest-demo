FROM openjdk:8-jre-alpine
RUN mkdir -p /usr/local/service
COPY target/springboot-rest-demo-0.0.1-SNAPSHOT.jar /usr/local/service/springboot-rest-demo-0.0.1-SNAPSHOT.jar
WORKDIR /usr/local/service
RUN chmod 777 -R /usr/local/service
RUN chmod 777 DORA-REST-Application-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","springboot-rest-demo-0.0.1-SNAPSHOT.jar"]
