[![Travis-ci Build Status](https://travis-ci.org/kchetan/accom-finder.svg?branch=master)](https://travis-ci.org/kchetan/accom-finder)
# Accommodation Finder
A webapp to find acommodation among the company employees. It is built in maven, Spring boot.

## Documentation

* This project has an `apiary` documentation. You can check [here](http://docs.accommodationfinder.apiary.io)
* The Er diagram of the Database. (End of Readme)
* Requirement Documentation for the project [here](https://drive.google.com/file/d/0BxNLMpY0NND3SXZlZTNldjdGaXc/view?usp=sharing)
* JavaDoc For code [here](http://ec2-52-32-21-2.us-west-2.compute.amazonaws.com/accomfinder/javadoc/index.html)
* Test Coverage [here] (http://ec2-52-32-21-2.us-west-2.compute.amazonaws.com/accomfinder/jacoco/index.html)


## Hosted on

 [amazon ec2 server](http://ec2-52-32-21-2.us-west-2.compute.amazonaws.com/accomfinder)
 
 [chetankasireddy.me](http://chetankasireddy.me/accomfinder/)

## Project Plan

  [Project plan](https://docs.google.com/a/practo.com/spreadsheets/d/1-AENyGqzP8uD_YZSTLBkqmftwDEM1vkPPhKkhF_Bm0I/edit?usp=sharing)
  
### Dependencies
The following should be installed in your machine to run the project.
* Java 8
* Maven
* Msql

### Technologies
* Java(LANGUAGE)
* Mysql (DATABASE)
* Hibernate (ORM )
* Javascript,Css
* Google sign in in javascript(User Authentication)
* HsqlDb (Used for testing)
* Google Checkstyle and code formatter
* New Relic [here](https://rpm.newrelic.com/accounts/1410169/applications/22261596)
	
* Travis ([here](https://travis-ci.org/kchetan/accom-finder))
* Amazon Ec2 for Hosting. ([here](http://ec2-52-32-21-2.us-west-2.compute.amazonaws.com/accomfinder))

## Installation and Running
This application is packaged as a `war`.
* First clone the repo.`git clone https://github.com/kchetan/accom-finder.git`
* Set up you application.properties in src/main/resources
* Create the database schema in local. You can get the script for database creation [here](https://github.com/kchetan/accom-finder/blob/master/documentation_files/script.sql)
*  To create a WAR
	`mvn clean generate-sources package`
* To start application
	- Using war  `java -jar target/accomfinder-0.0.1-SNAPSHOT.war`
	


### ER Diagram
![ER Diagram](https://raw.githubusercontent.com/kchetan/accom-finder/master/documentation_files/accommodation_erdiagram.png)


