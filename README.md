# CVA-Charge-Calculator
Database-based application for calculating a bank’s CVA Charge according to Article 384 CRR


In order to be able to run the application, the properties file (location: CVA-Charge-Calculator/src/main/resources/application.properties)
needs to be adapted.

The content of the file is the following:

spring.datasource.url=jdbc:mysql://localhost:3306/DatabaseCVA
spring.datasource.username=root
spring.datasource.password=YourPassword
spring.datasource.driverClassName=com.mysql.jdbc.Driver
spring.jpa.hibernate.ddl-auto=create

At least one change needs to be made here: the value for property spring.datasource.password has to be changed to the 
password for your database server.

In case you want to use a database other than MySQL or an ORM framework other than Hibernate, the relevant lines need
to be adapted as well.

To run the CVA Charge Calculator with actual data you can use the file "ExampleDataInput.xml".