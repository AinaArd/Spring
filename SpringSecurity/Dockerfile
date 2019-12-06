FROM maven:3.6.1-jdk-8-alpine

ARG JAR_FILE=target/springSecurity-0.1.jar
ADD ${JAR_FILE} springSecurity-0.1.jar
EXPOSE 8080

CMD ["java","-jar","/springSecurity-0.1.jar"]