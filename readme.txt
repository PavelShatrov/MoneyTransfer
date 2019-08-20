The application was build using Java EE specification with Payara server implementation.
To run from the command line(Java version 11 used):

java -jar payara-micro-5.192.jar --deploy target/MoneyTransfer-1.0-SNAPSHOT.war


Example of REST requests to test the functionalities

Create an account
curl -X POST -H "Content-Type: application/json" -d "{\"id\":\"111\", \"amount\":\"305\"}" localhost:8080/MoneyTransfer-1.0-SNAPSHOT/rest/resource/create

To make a transfer
curl -X POST -H "Content-Type: application/json" -d "{\"fromAccount\":\"333\",\"toAccount\":\"111\",\"amount\":\"200\"}" localhost:8080/MoneyTransfer-1.0-SNAPSHOT/rest/resource/transfer

To check an account state
curl -X GET localhost:8080/MoneyTransfer-1.0-SNAPSHOT/rest/resource/account/333