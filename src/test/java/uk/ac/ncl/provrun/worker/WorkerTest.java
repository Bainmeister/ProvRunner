package uk.ac.ncl.provrun.worker;

import junit.framework.TestCase;

/**
 * Created by simon on 24/06/15.
 */
public class WorkerTest extends TestCase {

    //TODO populate rules and test.
    public void testConstruction() throws Exception {
        Worker f;
        f = new Worker(new WorkerRules());
        assertNotNull(f);
    }



}