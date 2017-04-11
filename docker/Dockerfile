#FROM java:8-jre
#VOLUME /tmp
#ADD order_service.jar app.jar
#RUN bash -c 'touch /app.jar'
#EXPOSE 9090
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]


FROM openjdk:8-jre-alpine
EXPOSE 9090
ADD order_service.jar /app.jar
CMD ["java", "-jar", "/app.jar"]