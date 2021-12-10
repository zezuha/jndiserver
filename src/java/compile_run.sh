
javac -cp .:../../lib/jbossall-client.jar:../../lib/jnpserver.jar:../../lib/jboss-remote-naming-1.0.1.Final.jar:../../lib/log4j.jar  \
    jndiserver/StandaloneJNDIServer.java

java -cp .:../../lib/jbossall-client.jar:../../lib/jnpserver.jar:../../lib/jboss-remote-naming-1.0.1.Final.jar:../../lib/log4j.jar:../../lib2/jboss-minimal.jar:../../lib2/slf4j-jboss-logging.jar:../../lib2/jboss-logging-log4j.jar:../../lib2/jboss-logging-jdk.jar:../../lib2/jboss-logging-log4j.jar:../../lib2/jboss-logging-spi.jar:../../lib2/jboss-minimal.jar:../../lib2/log4j.jar:../../lib2/slf4j-jboss-logging.jar:../../lib2/jboss-common-core.jar \
    jndiserver.StandaloneJNDIServer
