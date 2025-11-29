# ---------- build stage ----------
FROM maven:3.8.7-eclipse-temurin-17 as build

WORKDIR /build
COPY pom.xml /build/
RUN mvn -q -f /build/pom.xml dependency:go-offline

COPY src /build/src
RUN mvn -q -f /build/pom.xml -DskipTests package

# ---------- run stage ----------
FROM eclipse-temurin:17-jre

ENV JAVA_OPTS="-Djava.security.egd=file:/dev/./urandom"

COPY --from=build /build/target/*.jar /app/library-app.jar

EXPOSE 8080

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /app/library-app.jar" ]