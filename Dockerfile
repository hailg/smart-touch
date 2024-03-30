FROM gradle:8.7.0-jdk17

ADD . /java-springboot
WORKDIR /java-springboot

RUN ls -l

RUN gradle build

# 2. Just using the build artifact and then removing the build-container
FROM openjdk:19-alpine

#ARG database_url
#ARG database_user
#ARG database_pass
#ARG openai_api_key

# https://security.alpinelinux.org/vuln/CVE-2021-46848
RUN apk add --upgrade libtasn1-progs

# https://security.alpinelinux.org/vuln/CVE-2022-37434
RUN apk update && apk upgrade zlib


# Create a new user with UID 10014
RUN addgroup -g 10014 choreo && \
    adduser  --disabled-password  --no-create-home --uid 10014 --ingroup choreo choreouser

VOLUME /tmp

USER 10014

# Add Spring Boot app.jar to Container
COPY --from=0 "/java-springboot/build/libs/smart-touch-*-SNAPSHOT.jar" app.jar

#ENV DATABASE_URL=$database_url
#ENV DATABASE_USER=$database_user
#ENV DATABASE_PASS=$database_pass
#ENV OPEN_AI_API_KEY=$openai_api_key
#RUN env

# Fire up our Spring Boot app by default
CMD [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]