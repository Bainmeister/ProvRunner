package uk.ac.ncl.provrun.datastore;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by simon on 23/06/15.
 */
public class MongoConnTest {

    @Test
    public void testDefaultConstuctor() {

        MongoConn conn = new MongoConn();
        assertNotNull(conn);

    }

    @Test
    public void testConstuctor() {
        MongoConn conn = new MongoConn("test", "collection");
        assertNotNull(conn);
    }

}