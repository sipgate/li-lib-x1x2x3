# -*- Makefile -*-
all: maven-validate copy-generated-java

#
# Variables
#

XSD_DIR:=src/main/resources
TARGET_PROJECT_SRC_MAIN_JAVA_DIR:=../src/main/java
GEN_DIR:=target/generated-sources/xjc

#
# Tools
#

MVN:=mvn

#
# Check for downloaded XSD files
#

_xsd_main_representative=$(XSD_DIR)/TS_103_280_v021101.xsd
_xsd_dep_representative=$(XSD_DIR)/TS_103_221_01.xsd
_catalog_file=$(XSD_DIR)/ts_103.cat

$(_xsd_main_representative):
	@echo 'Get XSD files from https://www.etsi.org/standards-search#page=1&search=103%20221-1&title=1&etsiNumber=1&content=0&version=0&onApproval=1&published=1&withdrawn=1&historical=0&isCurrent=1&superseded=1&startDate=1988-01-15&endDate=2040-01-01&harmonized=0&keyword=&TB=&stdType=&frequency=&mandate=&collection=&sort=1'
	@echo 'Save them in $(XSD_DIR)/'
	mkdir -p $(XSD_DIR)
	@false

$(_xsd_dep_representative):
	@echo 'Get XSD dependencies from https://www.etsi.org/deliver/etsi_ts/103200_103299/103280/02.12.01_60/'
	@echo 'Save them in $(XSD_DIR)/'
	mkdir -p $(XSD_DIR)
	@false

xsd-files: $(_xsd_main_representative) $(_xsd_dep_representative)


#
# XSD files to Java files
# - this generates *.java files into target/generated-sources/xjc/
# - it also comnpiles a jar file, but that is only to check the generated files
#

_generated_java_helper_representative=$(GEN_DIR)/com/kscs/util/jaxb/Buildable.java
_generated_java_xsd_representative=$(GEN_DIR)/org/etsi/uri/_03221/x1/_2017/_10/ActivateTaskRequest.java

$(_generated_java_helper_representative): maven-validate
$(_generated_java_xsd_representative): maven-validate

maven-validate: pom.xml xsd-files $(_catalog_file)
	$(MVN) clean package


#
# Copy generated Java files to the project
#

copy-generated-java: $(_generated_java_xsd_representative) $(_generated_java_helper_representative)
	rm -v -r $(TARGET_PROJECT_SRC_MAIN_JAVA_DIR)/org/etsi
	rm -v -r $(TARGET_PROJECT_SRC_MAIN_JAVA_DIR)/com/kscs/util/
	cp -v -r $(GEN_DIR)/* $(TARGET_PROJECT_SRC_MAIN_JAVA_DIR)
	rm -v $(TARGET_PROJECT_SRC_MAIN_JAVA_DIR)/META-INF/*.episode

