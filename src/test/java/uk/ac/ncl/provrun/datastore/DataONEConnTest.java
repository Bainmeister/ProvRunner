package uk.ac.ncl.provrun.datastore;

import junit.framework.TestCase;

/**
 * Created by simon on 24/06/15.
 */
public class DataONEConnTest extends TestCase {

    public void testConnect() throws Exception {
        DataONEConn conn = new DataONEConn();
        assertEquals(conn.connect(), true);
    }

    public void testDisconnect() throws Exception {
        DataONEConn conn = new DataONEConn();
        assertEquals(conn.disconnect(), true);
    }
}