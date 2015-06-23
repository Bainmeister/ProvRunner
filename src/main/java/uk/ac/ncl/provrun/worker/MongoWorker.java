package uk.ac.ncl.provrun.worker;

import com.mongodb.client.MongoCollection;
import uk.ac.ncl.provrun.datastore.MongoAction;

/**
 * Created by simon on 23/06/15.
 */
public class MongoWorker implements WorkerFace {

    //A worker will:
    //  write new documents
    //  read exisiting documents
    //  update exisitng

    private MongoCollection collection;
    private MongoAction act = new MongoAction(collection);


    //We don't want anybody setting upwithout specifying the collection that the worker should be using
    private MongoWorker(){}
    MongoWorker(MongoCollection collection){this.collection = collection;}


    public boolean write(String key) { return act.write(key); }

    public boolean read(String key) {
        return act.read(key);
    }

    public boolean update(String key) { return (read(key) && write(key) ? true : false); }
    
}
