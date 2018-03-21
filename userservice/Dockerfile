FROM java:8-jre

ADD ./target/userservice-1.0-SNAPSHOT.jar /app/app.jar
CMD ["java", "-Xmx200m", "-jar", "/app/app.jar"]

HEALTHCHECK --interval=10s --timeout=3s CMD curl -f http://localhost:8080/health || exit 1

EXPOSE 8080
