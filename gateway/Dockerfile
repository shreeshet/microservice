FROM java:7-jre

ADD ./target/gateway-1.0-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/gateway-1.0-SNAPSHOT.jar"]

HEALTHCHECK --timeout=3s CMD curl -f http://localhost:8765/health || exit 1

EXPOSE 8765
