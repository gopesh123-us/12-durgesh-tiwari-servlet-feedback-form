WORKDIR /app

RUN apt-get update && apt-get install -y git

RUN apt-get update && apt-get install -y git

RUN git clone https://github.com/gopesh123-us/12-durgesh-tiwari-servlet-feedback-form.git /app

FROM maven:3.9.6 as build

COPY . .

RUN mvn clean package

FROM tomcat:10.0-jdk21-openjdk

COPY --from=build /app/target/feedback-form.war /usr/local/tomcat/webapps/feedback-form.war

EXPOSE 8080

CMD ["catalina.sh", "run"]