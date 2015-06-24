package uk.ac.ncl.provrun.connection;

import junit.framework.TestCase;

/**
 * Created by simon on 24/06/15.
 */
public class MongoConnTest extends TestCase {


    public void testConnect() throws Exception {
        MongoConnection conn = new MongoConnection();
        assertEquals(conn.connect(),true);
    }

    public void testConnect1() throws Exception {
        MongoConnection conn = new MongoConnection();
        assertEquals(conn.connect("test","prov"), true);
    }

    public void testDisconnect() throws Exception {
        MongoConnection conn = new MongoConnection();
        assertEquals(conn.disconnect(), true);
    }

}