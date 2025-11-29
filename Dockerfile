# Dockerfile

# 1. ЕТАП ЗБІРКИ (BUILDER STAGE)
# Використовуємо надійний JDK образ для компіляції та пакування
FROM openjdk:17-jdk-slim-bullseye AS builder 

WORKDIR /app

# Копіюємо зібраний JAR-файл
COPY target/library-0.0.1-SNAPSHOT.jar app.jar

# 2. ФІНАЛЬНИЙ ЕТАП (FINAL STAGE)
# Використовуємо мінімальний JRE образ для запуску
FROM openjdk:17-jre-slim-bullseye 

# Створення користувача 'spring'
RUN groupadd spring && useradd spring -g spring
USER spring
WORKDIR /home/spring

# Копіюємо зібраний JAR з етапу builder
COPY --from=builder /app/app.jar app.jar

EXPOSE 8080

# Точка входу: запуск Spring Boot застосунку
ENTRYPOINT ["java", "-jar", "app.jar"]
