package uk.ac.ncl.provrun.worker;

import junit.framework.TestCase;
import uk.ac.ncl.provrun.dataMachine.DataType;
import uk.ac.ncl.provrun.performance.ActionReport;

/**
 * Created by simon on 24/06/15.
 */
public class WorkerTest extends TestCase {

    //TODO populate rules and test.
    public void testConstruction() throws Exception {

        WorkerRules rules = new WorkerRules(DataType.FILE_STORE, 10,10,100,1,2,1000,10, "/home/simon/Data");
        rules.setDisplay(true);
        Worker worker = new Worker(rules);
        ActionReport report = worker.doWork();

        report.getReport();

    }



}