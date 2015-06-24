package uk.ac.ncl.provrun.datastore;

import junit.framework.TestCase;

/**
 * Created by simon on 24/06/15.
 */
public class MongoActionTest extends TestCase {

    //TODO - ensure an @before and an @after adds and removes any relevant keys
    public void testRead() throws Exception {
        MongoAction act = new MongoAction(new MongoConn().getCollection());
        assertEquals(act.read("key"),true);
    }

    //TODO - ensure an @before and an @after adds and removes any relevant keys
    public void testWrite() throws Exception {
        MongoAction act = new MongoAction(new MongoConn().getCollection());
        assertEquals(act.write("key"),true);
    }
}