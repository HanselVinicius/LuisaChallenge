FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . /app

EXPOSE 8080

RUN chmod +x start.sh gradlew && ./gradlew getDependencies

CMD ["sh", "start.sh"]