FROM ubuntu:latest
MAINTAINER rocketeerbkw@gmail.com

RUN  apt-get update \
  && apt-get install -y wget default-jre
RUN wget http://downloads.sourceforge.net/project/winstone/winstone/v0.9.10/winstone-0.9.10.jar

CMD ["-jar", "winstone-0.9.10.jar", "--webappsDir=/tdash/build", "--directoryListings=false", "LOGGING='--accessLoggerClassName=winstone.accesslog.SimpleAccessLogger'", "--httpPort=80"]
ENTRYPOINT ["java"]
