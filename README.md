# _Database basics independent project: Hair Salon_

#### _An app for a hair salon database., May 6, 2016_

#### By _Inthrayuth Mahaphol_

## Description

_The salon owner will be able to add a list of the stylists and clients. Each stylist can be added to clients who see that stylist. The stylists work independently, so each client only belongs to a single stylist. The app uses one-to-many relationship database style._

Databases:
* Production database is called "hair_salon"
* Development database is called "hair_salon_test". The development database should be created by duplicating from production database.
* There are tables in the production database: "clients" and "stylists".
* SQL database dump file is named hair_salon.sql

## Setup/Installation Requirements

* _Link to repository: https://github.com/inthra/w3Fri-HairSalon.git_
* _Download this repository to your computer_
* _Create a project directory up on your computer_
* _Java, Gradle, and Postgres apps need to be installed on your computer_
* _Run "gradle run" on command line and go to url "localhost:4567" on a web browser_

## Setup database

* Open a terminal and run "postgres" to access the Postgres server.
* Open another terminal and run "psql". These process will give you ability to create databases and tables.

  In PSQL:
*  =# CREATE DATABASE hair_salon;
*  =# \c hair_salon;
*  hair_salon=# CREATE TABLE clients (id serial PRIMARY KEY, name varchar, stylist_id int);
*  hair_salon=# CREATE TABLE stylists (id serial PRIMARY KEY, name varchar);
*  hair_salon=# CREATE DATABASE hair_salon_test WITH TEMPLATE hair_salon;

## Known Bugs

* There is no feature to prevent duplication data when user input new clients or stylists to the database.
* White space can be inputted to database with no feature to delete it.

## Support and contact details

_Feel free to contact me with questions or suggestions._
_Inthrayuth Mahaphol: zign.int@gmail.com_

## Technologies Used

* _Git_
* _Github_
* _Java_
* _Gradle_
* _Postgres_
* _Spark_
* _Apache Velocity_ (Using the Velocity Template Engine)

### License

*This software is licensed under the MIT license*

Copyright (c) 2016 Inthrayuth M.
