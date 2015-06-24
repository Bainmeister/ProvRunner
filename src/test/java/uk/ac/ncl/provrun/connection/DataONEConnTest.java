package uk.ac.ncl.provrun.connection;

import junit.framework.TestCase;

/**
 * Created by simon on 24/06/15.
 */
public class DataONEConnTest extends TestCase {

    public void testConnect() throws Exception {
        DataONEConnection conn = new DataONEConnection();
        assertEquals(conn.connect(), true);
    }

    public void testDisconnect() throws Exception {
        DataONEConnection conn = new DataONEConnection();
        assertEquals(conn.disconnect(), true);
    }
}