FROM java:8-jre
ADD ./zipkin.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/zipkin.jar"]

EXPOSE 9411
