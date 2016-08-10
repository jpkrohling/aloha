FROM fabric8/java-jboss-openjdk8-jdk:1.1.4

ENV JAVA_APP_JAR aloha-fat.jar
ENV AB_ENABLED jolokia
ENV AB_JOLOKIA_AUTH_OPENSHIFT true

EXPOSE 8080

RUN chgrp -R 0 /app/
RUN chmod -R g+rw /app/
ADD target/aloha-fat.jar /app/
