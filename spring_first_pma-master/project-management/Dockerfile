FROM ubuntu:latest

RUN apt-get update && apt-get install -y openjdk-8-jdk

WORKDIR /usr/local/bin/

ADD target/project-management.jar .

# CMD ["/bin/bash"]

ENTRYPOINT ["java", "-jar", "project-management.jar"]