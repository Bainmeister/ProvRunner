package uk.ac.ncl.provrun.worker;

/**
 * Created by simon on 23/06/15.
 * A worker can do one of 4 tasks (read/write/update/nothing).
 */
public interface WorkerFace {

    /**
     * Write something new to the data store.
     * @return
     */
    boolean write(String key);

    /**
     * Read something from the data store.
     * @return
     */
    boolean read(String key);

    /**
     * Update existing data within the data store.
     * @return
     */
    boolean update(String key);

}
