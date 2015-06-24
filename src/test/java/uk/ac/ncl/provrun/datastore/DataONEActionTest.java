package uk.ac.ncl.provrun.datastore;

import junit.framework.TestCase;

/**
 * Created by simon on 24/06/15.
 */
public class DataONEActionTest extends TestCase {

    //TODO - ensure an @before and an @after adds and removes any relevant keys
    public void testRead() throws Exception {
        DataONEAction act = new DataONEAction();
        assertEquals(act.read("key"), true);
    }

    //TODO - ensure an @before and an @after add and remove any relevant keys
    public void testWrite() throws Exception {
        DataONEAction act = new DataONEAction();
        assertEquals(act.write("key"), true);
    }
}