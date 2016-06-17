rem Be sure to set the path to point to %gf_install%\glassfish\bin before running this batch file

@echo off
call asadmin start-domain
pause
call asadmin create-jdbc-connection-pool --datasourceclassname org.apache.derby.jdbc.ClientDataSource --restype javax.sql.XADataSource --property portNumber=1527:password=APP:user=APP:serverName=localhost:databaseName=SE554DB:connectionAttributes=\;create\=true SE554Pool
pause
call asadmin create-jdbc-resource --connectionpoolid SE554Pool jdbc/SE554
pause
call asadmin stop-domain
pause
