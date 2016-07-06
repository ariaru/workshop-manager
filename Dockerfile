FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/workshop-manager.jar /workshop-manager/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/workshop-manager/app.jar"]
