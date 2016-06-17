JEE6 Calculator

Tested using

  IDE:  Eclipse and Netbeans

  Server:  Glassfish

Prior to adding the calculator application

1) Start the server

2) Add the JMS info

    If using Glassfish, can create the necessary resources using following 2 commands

    ./asadmin create-jms-resource --restype javax.jms.QueueConnectionFactory jms/QueueConnectionFactory

    ./asadmin create-jms-resource --restype javax.jms.Queue jms/CalculatorQ

3)  If using Eclipse with Glassfish

    Define jdbc/sample database which match the parameter as jdbc/__default

    Be sure to use Data Source Explorer to start the Sample database


Demo to show

1)  JPA

2)  SB

3)  MDB


