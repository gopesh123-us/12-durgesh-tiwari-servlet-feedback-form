FROM tomcat:10.1-jdk21-openjdk

COPY ./target/*.war /usr/local/tomcat/webapps/feedback-form.war

EXPOSE 8080

CMD ["catalina.sh", "run"]