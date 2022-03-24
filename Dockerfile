FROM openjdk:11
#COPY target/java-1.8.0-amazon-corretto-jdk_8.322.06-2_amd64.deb /opt/project/jdk/
#RUN apt-get install openjdk-11-jdk
RUN #dpkg -i /opt/project/jdk/java-1.8.0-amazon-corretto-jdk_8.322.06-2_amd64.deb
RUN apt-get update
COPY target/compliance.jar /opt/project/

ENTRYPOINT ["java","-jar","/opt/project/compliance.jar","> tomcat.log &"]
