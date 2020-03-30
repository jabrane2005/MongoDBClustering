package org.example.mongodb;

/**
 * Hello world!
 *
 */
import com.mongodb.*;
import java.net.UnknownHostException;
public class App 
{
    public static void main(String[] args) {
        try {
            // Creates a new instance of MongoDBClient and connect to localhost
            // port 27017.
            MongoClient client = new MongoClient(
                    new ServerAddress("localhost", 27017));

            // Gets the test from the MongoDB instance.
            DB database = client.getDB("test");

            // Gets the users collections from the database.
            DBCollection collection = database.getCollection("users");

            // Gets a single document / object from this collection.
            DBObject document = collection.findOne();
            System.out.println("DONE");
            // Prints out the document.
            System.out.println(document);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
