# Dockerfile

# 1. ЕТАП ЗБІРКИ (BUILDER STAGE)
# Використовуємо Amazon Corretto 17 JDK для компіляції та пакування
FROM amazoncorretto:17-jdk AS builder 

# Встановлюємо робочу директорію
WORKDIR /app

# Копіюємо зібраний JAR-файл
# Назва файлу згідно з вашим pom.xml
COPY target/library-0.0.1-SNAPSHOT.jar app.jar

# 2. ФІНАЛЬНИЙ ЕТАП (FINAL STAGE)
# Використовуємо мінімальний Amazon Corretto 17 JRE для запуску
# Alpine - це мінімалістичний дистрибутив, що дає дуже маленький образ.
FROM amazoncorretto:17-jre-alpine 

# Створення користувача 'spring' для підвищення безпеки (рекомендовано)
RUN addgroup -S spring && adduser -S spring -G spring
USER spring
WORKDIR /home/spring

# Копіюємо зібраний JAR з етапу builder
COPY --from=builder /app/app.jar app.jar

# Визначаємо порт для запуску
EXPOSE 8080

# Точка входу: запуск Spring Boot застосунку
ENTRYPOINT ["java", "-jar", "app.jar"]
