#!/bin/bash

##
## This file is part of the sample code for the article,
## "What is Jetty,"
## http://www.onjava.com/pub/a/onjava/2006/06/14/what-is-jetty.html
## by Ethan McCallum
## 
## This code was tested against Jetty 5.1.10 and Sun's JDK 1.5.0_03.
##


declare -r JETTY_DIST="/opt/thirdparty/dist/jetty-5"
declare -r JAVA_DIST="/opt/thirdparty/dist/java-1.5"
declare -r -a CLASSPATH_ENTRIES=(

	resources
	bin

	${JETTY_DIST}/ext/commons-el.jar
	${JETTY_DIST}/ext/commons-logging.jar
	${JETTY_DIST}/ext/jasper-compiler.jar
	${JETTY_DIST}/ext/jasper-runtime.jar

	${JETTY_DIST}/lib/javax.servlet.jar
	${JETTY_DIST}/lib/org.mortbay.jetty.jar
	${JETTY_DIST}/lib/org.mortbay.jmx.jar

)

## - - - - - - - - - -

CLASSPATH=""

for ENTRY in ${CLASSPATH_ENTRIES[*]} ; do

	CLASSPATH=${CLASSPATH}:${ENTRY}

done

export CLASSPATH

${JAVA_DIST}/bin/java \
 	-Djetty.class.path=${CLASSPATH} \
 	-jar ${JETTY_DIST}/start.jar \
	resources/step2-service-config.xml
