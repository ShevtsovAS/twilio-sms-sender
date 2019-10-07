FROM openjdk
ARG JAR_FILE
COPY ${JAR_FILE} /twilio-sms-sender.jar
ENTRYPOINT ["java","-jar","/twilio-sms-sender.jar"]
EXPOSE 8080