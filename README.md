# MongoDBClustering

-------------------------------------------------------------------------------------
------------------ How to run MongoDB and Kmeans in a java project-------------------
------------------For more information contact jabrane2005@gmail.com-----------------
-------------------------------------------------------------------------------------

This java project explains how to store diffrent data coming from different sources 
into a MongoDB database.then,applying k-means algorithm to cluster these data.
To run this program,you need:
-Install Java 8 version
-Create maven project
-Add MongoDB dependency into pom.xml as bellow:
	<dependency>
      <groupId>org.mongodb</groupId>
      <artifactId>mongo-java-driver</artifactId>
      <version>2.12.3</version>
    </dependency>
-install MongoDB and run mongod.exe and  mongo.exe commands	

Java project classes description
-App.java to test connection,if you keep default setting of MongoDB,there will be no changes in App class.
-FilesStorage.java save different files into MongoDB.
-algokmeans.java start clustering by the given parameters
	
