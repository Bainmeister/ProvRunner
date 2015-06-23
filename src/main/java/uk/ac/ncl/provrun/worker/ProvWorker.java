package uk.ac.ncl.provrun.worker;

/**
 * Created by simon on 23/06/15.
 */
public class ProvWorker implements WorkerFace{

    public boolean write() {
        return false;
    }

    public boolean read() {
        return false;
    }

    public boolean update() {
        return false;
    }

    public boolean doNothing() {
        return false;
    }
}
