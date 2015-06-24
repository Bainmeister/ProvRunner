package uk.ac.ncl.provrun.datastore;

import junit.framework.TestCase;

/**
 * Created by simon on 24/06/15.
 */
public class MongoConnTest extends TestCase {


    public void testConnect() throws Exception {
        MongoConn conn = new MongoConn();
        assertEquals(conn.connect(),true);
    }

    public void testConnect1() throws Exception {
        MongoConn conn = new MongoConn();
        assertEquals(conn.connect("test","prov"), true);
    }

    public void testDisconnect() throws Exception {
        MongoConn conn = new MongoConn();
        assertEquals(conn.disconnect(), true);
    }

}