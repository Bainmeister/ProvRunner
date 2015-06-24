package uk.ac.ncl.provrun.worker;

import junit.framework.TestCase;

/**
 * Created by simon on 24/06/15.
 */
public class FileWorkerTest extends TestCase {

    public void testConstruction() throws Exception {
        FileWorker f;
        f = new FileWorker("/home/simon/Documents");
        assertNotNull(f);
    }

}