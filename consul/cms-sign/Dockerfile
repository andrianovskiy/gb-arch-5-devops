FROM  adoptopenjdk/openjdk11:alpine-jre

ADD consul_1.13.1_linux_amd64.zip /tmp/consul.zip
RUN cd /bin && unzip /tmp/consul.zip && chmod +x /bin/consul && rm /tmp/consul.zip

ADD cms_sign.sh /opt
RUN chmod +x /opt/cms_sign.sh

RUN mkdir -p /data/db /etc/consul.d
ADD ./consul /etc/consul.d

COPY check-cms-1.0-SNAPSHOT.jar /check-cms.jar

EXPOSE 8080
CMD ["/opt/cms_sign.sh"]