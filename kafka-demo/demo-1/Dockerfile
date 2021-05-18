FROM ubuntu:20.04

RUN apt-get update && apt-get install -y locales && rm -rf /var/lib/apt/lists/* \
    && localedef -i en_US -c -f UTF-8 -A /usr/share/locale/locale.alias en_US.UTF-8
ENV LANG en_US.utf8

RUN apt-get update && apt-get install -y build-essential
RUN apt-get install -y python3
RUN apt-get install -y python3-pip
RUN pip3 install confluent-kafka
RUN pip3 install paho-mqtt
RUN apt-get install -y mosquitto  mosquitto-clients

WORKDIR /code
