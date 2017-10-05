FROM openjdk:8u111-jdk-alpine

COPY /build/libs/*.jar app.jar
ADD ./start.sh start.sh

ENTRYPOINT ["sh", "/start.sh"]