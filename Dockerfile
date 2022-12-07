FROM openjdk:8
ADD build/libs/*.jar sql-springt.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/sql-springt.jar"]