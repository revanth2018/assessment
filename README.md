# assessment
Charter Assessment

### Environment Requirements

* Java 1.8 and above
* Spring boot
* Spring JPA
* H2 database
* Lombok
* Maven build tool

### Run Locally
* Install Maven using **mvn clean install** command from root path or install from preferred IDE
  Build Maven using
* Run spring boot app using **mvn spring-boot:run** command from root path or trigger the application from IDE

### Set up Local h2 database

* Application.properties has h2 database configurations. Once application starts, it will create local database.
* Tables and data will be created based on queries in data.sql and schema details in schema.sql under resources folder. Every time application restarts Data
  will be cleaned up and create new entries.Since local database doesn't hold the data.
* Once application starts, use http://localhost:8080/api/assessment/h2-console link to open database in browser. User and Password details were provided in application.properties file
* Database has two tables. **User table** to store user information and **Transaction tabl**e for storing user's transactions.
* User details were pre-defined in data.sql file and inserted in USER table. If you want to insert new user please add the query accordingly in data.sql
* Few Transactions details were already defined in TRANSACTION table. More transaction can be added to the table via API call.

## Endpoints
*  Two endpoints were created **/saveUserTransaction** and **/getRewards**.
*  /saveUserTransaction is for creating transaction for each user. Pass Customer Id and Transaction details(amount and Month) in message body.
*  /getRewards is for fetching rewards by passing customer Id. This will return each month rewards for last 3 months rewards and total rewards for every user.
   Note: Please use Customer ids as (1 to 10) since they are already defined in User table. If you want to try different string for customerID and customer details please insert them in user table via data.sql
* Please use postman to test the APIs. Local port is 8080 so http://localhost:8080/api/assessment/saveUserTransaction and http://localhost:8080/api/assessment/getRewards endpoints from postman.

