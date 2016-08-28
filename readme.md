[![Travis-ci Build Status](https://travis-ci.org/kchetan/accom-finder.svg?branch=master)](https://travis-ci.org/kchetan/accom-finder)
# Accommodation Finder
A webapp to find acommodation among the company employees. It is built in maven, Spring boot.

## Hosted on
 [amazon ec2 server](http://ec2-52-43-52-91.us-west-2.compute.amazonaws.com/accomfinder/)

### Dependencies
The following should be installed in your machine to run the project.
* Java 8
* Maven
* Msql

## Installation and Running
This application is packaged as a `war`.
* First clone the repo.`git clone https://github.com/kchetan/accom-finder.git`
* Set up you application.properties in src/main/resources
* Create the database schema in local. You can get the script for database creation [here](https://github.com/kchetan/accom-finder/blob/master/documentation_files/script.sql)
*  To create a JAR
	`mvn clean generate-sources package`
* To start application
	- Using jar  `java -jar target/car-pool-0.0.1-SNAPSHOT.jar`
	- Without jar `mvn spring-boot:run`
	
## Documentation

* This project has an `apiary` documentation. You can check [here](http://docs.accommodationfinder.apiary.io)
* The Er diagram of the Database.

### ER Diagram
![ER Diagram](https://raw.githubusercontent.com/kchetan/accom-finder/master/documentation_files/accommodation_erdiagram.png)

* Requirement Documentation for the project [here](https://github.com/kchetan/accom-finder/blob/master/documentation_files/document.pages)

