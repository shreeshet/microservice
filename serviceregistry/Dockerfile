FROM java:7-jre

ADD ./target/serviceregistry-1.0-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/serviceregistry-1.0-SNAPSHOT.jar"]

EXPOSE 8761
