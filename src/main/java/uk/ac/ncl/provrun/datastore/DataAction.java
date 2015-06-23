package uk.ac.ncl.provrun.datastore;

/**
 * Created by simon on 23/06/15.
 */
public interface DataAction {

    /**
     * Reads a document wuth the relevant key (if it exists)
     * @param key
     * @return
     */
    boolean read(String key);

    /**
     * Writes to a document with the relevant key. Otherwise a new one is created.
     * @param key
     * @return
     */
    boolean write(String key);

}
