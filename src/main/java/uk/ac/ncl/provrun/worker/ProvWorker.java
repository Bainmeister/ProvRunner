package uk.ac.ncl.provrun.worker;

/**
 * Created by simon on 23/06/15.
 */
public class ProvWorker implements WorkerFace{

    //A worker will:
    //  write new documents
    //  read exisiting documents
    //  update exisitng

    public boolean write(String key) {
        return false;
    }

    public boolean read(String key) {
        return false;
    }

    public boolean update(String key) {
        return false;
    }



}
