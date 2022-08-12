FROM  adoptopenjdk/openjdk11:alpine-jre

COPY target/check-cms-1.0-SNAPSHOT.jar /check-cms.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/check-cms.jar"]