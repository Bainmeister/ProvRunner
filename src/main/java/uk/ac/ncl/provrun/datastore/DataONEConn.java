package uk.ac.ncl.provrun.datastore;

/**
 * Created by simon on 23/06/15.
 */
public class DataONEConn implements DataConn {

    /**
     * Connect to the default database and collection
     * @return
     */
    //TODO - use APIs to connect to DataONE
    public boolean connect() {
        return true;
    }

    /**
     * There is no real need to do this, but if required all connection details can be dropped.
     * @return
     */
    //TODO - use APIs to connect to DataONE
    public boolean disconnect() {
        return true;
    }
}
