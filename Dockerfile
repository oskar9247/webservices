FROM openjdk:10-jdk as webservicebuilder

RUN apt-get update && apt-get install -y maven

#Download maven dependencies. This step is repeated only if the pom or the base image was changed
COPY pom.xml pom.xml
RUN mvn dependency:go-offline

#This step is repeated if any file has changed
COPY . .
RUN mvn clean package







FROM openjdk:10-jdk

COPY --from=0 /target/webservice*.jar webservice.jar
CMD java -jar webservice.jar

HEALTHCHECK CMD curl localhost:8080/actuator/health