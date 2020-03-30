package org.example.mongodb;

import com.mongodb.*;
import java.io.File;
import java.io.IOException;

import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import java.net.UnknownHostException;

public class FilesStorage {
    private static void saveImageIntoMongoDB(DB db) throws IOException {
        String dbFileName = "6979-31145-1-PB";
        File imageFile = new File("C:\\documents\\6979-31145-1-PB.pdf");
        GridFS gfsPhoto = new GridFS(db, "document");
        GridFSInputFile gfsFile = gfsPhoto.createFile(imageFile);
        gfsFile.setFilename(dbFileName);
        gfsFile.save();
    }
    private static void getSingleImageExample(DB db) {
        String newFileName = "C:/documents/6979-31145-1-PB";
        GridFS gfsPhoto = new GridFS(db, "document");
        GridFSDBFile imageForOutput = gfsPhoto.findOne(newFileName);
        System.out.println(imageForOutput);
    }
    private static void listAllImages(DB db) {
        GridFS gfsPhoto = new GridFS(db, "document");
        DBCursor cursor = gfsPhoto.getFileList();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }
    public static void main(String[] args) {
        try {
            MongoClient client = new MongoClient(
                    new ServerAddress("localhost", 27017));

            // Gets the test from the MongoDB instance.
            DB db = client.getDB("test");

            //Save a image in DB
            saveImageIntoMongoDB(db);
            //Get a image from DB
            getSingleImageExample(db);
            //Get all images from DB
           listAllImages(db);
            System.out.println("SAVE DONE");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
