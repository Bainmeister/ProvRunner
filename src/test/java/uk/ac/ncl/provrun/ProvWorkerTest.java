package uk.ac.ncl.provrun;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import uk.ac.ncl.provrun.worker.ProvWorker;

/**
 * Created by simon on 23/06/15.
 */
public class ProvWorkerTest {

    @Test
    public void evaluateWrite() {
        ProvWorker worker = new ProvWorker();
        assertEquals(true, worker.write());
    }

    @Test
    public void evaluateRead() {
        ProvWorker worker = new ProvWorker();
        assertEquals(true, worker.read());
    }

    @Test
    public void evaluateUpdate() {
        ProvWorker worker = new ProvWorker();
        assertEquals(true, worker.update());
    }

    @Test
    public void evaluateDoNothing() {
        ProvWorker worker = new ProvWorker();
        assertEquals(true, worker.doNothing());
    }
}
