package uk.ac.ncl.provrun.worker;

import com.mongodb.client.MongoCollection;
import uk.ac.ncl.provrun.datastore.MongoAction;

/**
 * Created by simon on 23/06/15.
 */
public class MongoWorker implements WorkerFace {

    private MongoCollection collection;
    private MongoAction act = new MongoAction(collection);

    /*
        We require a collection, so block the standard constructor.
     */
    private MongoWorker(){}
    MongoWorker(MongoCollection collection){this.collection = collection;}

    //Perform the MongoAction of writing
    public boolean write(String key) { return act.write(key); }

    //Perform the MongoAction of reading
    public boolean read(String key) { return act.read(key); }

    //Perform the MongoAction of reading and then the mongo action of writing
    public boolean update(String key) { return (read(key) && write(key)); }

}
