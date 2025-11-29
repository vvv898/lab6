# Dockerfile

# Використовуємо офіційний образ Java 17
FROM openjdk:17-jdk-slim as builder

# Встановлюємо робочу директорію
WORKDIR /app

# Копіюємо зібраний JAR-файл
# Назва файлу залежить від pom.xml: artifactId-version.jar
# У вашому випадку це library-0.0.1-SNAPSHOT.jar
COPY target/library-0.0.1-SNAPSHOT.jar app.jar

# Визначаємо порт для запуску
EXPOSE 8080

# Точка входу: запуск Spring Boot застосунку
ENTRYPOINT ["java", "-jar", "app.jar"]