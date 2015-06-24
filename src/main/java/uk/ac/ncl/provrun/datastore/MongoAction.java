package uk.ac.ncl.provrun.datastore;

import com.mongodb.client.MongoCollection;

/**
 * Created by simon on 23/06/15.
 * We only need ONE CONNECTION for all of the calls
 */
public class MongoAction implements DataAction {

    //Keep this to ourselves for now. I may add methods to allow changes.
    private MongoCollection collection;

    /*  We can't do things to a collection without the collection. Lets make
    *   sure that we don't let anyone use it without specifying a collection!
    */
    private MongoAction(){ }

    public MongoAction(MongoCollection collection){
        this.collection = collection;
    }

    /**
     * Reads the document with the key given
     * @param key
     * @return
     */
    public boolean read(String key) {
        //TODO
        return true;
    }


    /**
     * Writes a document - if a key exists, that document is updated
     * @return
     */
    public boolean write(String key) {
        //TODO
        return true;

    }
}
