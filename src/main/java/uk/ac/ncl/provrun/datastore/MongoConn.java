package uk.ac.ncl.provrun.datastore;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Created by simon on 23/06/15.
 * We only need ONE CONNECTION for all of the calls
 */
public class MongoConn implements DataConn {

    //Connection details
    private MongoClient mongoClient;
    private MongoDatabase db;
    private MongoCollection collection;


    /**
     * Constructors connect to default DB unless otherwise instructed.
     */
    MongoConn(){
        connect();
    }

    MongoConn(String db, String collection){
        connect(db,collection);
    }

    /**
     * Connect to the Mongo db with a specific Database name and collection
     * @param dbname
     * @param collectionName
     * @return
     */
     public boolean connect(String dbname, String collectionName){


         return true;
         /*


         //TODO
         // Connect the client, the db, and the collection.
         mongoClient = new MongoClient("localhost" , 27017);

         //get OR create db 'dbname'
         db = mongoClient.getDatabase(dbname);

         //get OR create collection 'collectionName'
         collection = db.getCollection(collectionName);

         //We assume all the other steps work if we have a client.
         return  (mongoClient == null) ? false : true;

         */
    }

    /**
     * Connect to the default database and collection
     * @return
     */
    public boolean connect() {
        return connect("test", "prov");
    }

    /**
     * There is no real need to do this, but if required all connection details can be dropped.
     * @return
     */
    public boolean disconnect() {
        mongoClient = null;
        db = null;
        collection = null;
        return true;
    }

    public MongoCollection getCollection() {
        return collection;
    }

}
