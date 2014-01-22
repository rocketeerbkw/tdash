#!/usr/bin/env bash

# System deps
apt-get update
apt-get install -y default-jre unzip git

# Program deps
mkdir /vagrant/bin
wget https://github.com/downloads/yui/yuicompressor/yuicompressor-2.4.2.zip
unzip yuicompressor-2.4.2.zip
cp yuicompressor-2.4.2/build/yuicompressor-2.4.2.jar /vagrant/bin/
wget http://repo.typesafe.com/typesafe/ivy-releases/org.scala-tools.sbt/sbt-launch/0.10.0/sbt-launch.jar
cp sbt-launch.jar /vagrant/bin/sbt-launch_0.10.jar
wget http://downloads.sourceforge.net/project/winstone/winstone/v0.9.10/winstone-0.9.10.jar
cp winstone-0.9.10.jar /vagrant/bin/
