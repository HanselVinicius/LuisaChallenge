FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . /app

EXPOSE 8080

RUN chmod +x start.sh && ./gradlew getDependencies

CMD ["sh", "start.sh"]