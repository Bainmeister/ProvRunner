package uk.ac.ncl.provrun.worker;

import uk.ac.ncl.provrun.performance.ActionRecord;

/**
 * Created by simon on 23/06/15.
 * A worker can do one of 4 tasks (read/write/update/nothing).
 */
public interface WorkerFace {

    ActionRecord doWork();

}
