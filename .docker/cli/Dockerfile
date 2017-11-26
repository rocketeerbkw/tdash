FROM ubuntu:trusty
MAINTAINER rocketeerbkw@gmail.com

RUN  apt-get update \
  && apt-get install -y build-essential wget unzip default-jre make ruby-dev
RUN gem install sass -v 3.4.25
RUN mkdir -p /tdash/bin
RUN wget https://github.com/downloads/yui/yuicompressor/yuicompressor-2.4.2.zip
RUN wget http://repo.typesafe.com/typesafe/ivy-releases/org.scala-tools.sbt/sbt-launch/0.10.0/sbt-launch.jar
RUN unzip yuicompressor-2.4.2.zip
RUN cp yuicompressor-2.4.2/build/yuicompressor-2.4.2.jar /tdash/bin/
RUN cp sbt-launch.jar /tdash/bin/sbt-launch_0.10.jar

WORKDIR /tdash
