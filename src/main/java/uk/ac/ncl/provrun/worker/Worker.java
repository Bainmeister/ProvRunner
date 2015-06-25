package uk.ac.ncl.provrun.worker;

import uk.ac.ncl.provrun.connection.DataConnection;
import uk.ac.ncl.provrun.connection.MongoConnection;
import uk.ac.ncl.provrun.dataMachine.DataMachine;
import uk.ac.ncl.provrun.dataMachine.DataONE;
import uk.ac.ncl.provrun.dataMachine.FileStore;
import uk.ac.ncl.provrun.dataMachine.Mongo;
import uk.ac.ncl.provrun.performance.ActionReport;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static uk.ac.ncl.provrun.dataMachine.DataType.*;

/**
 * Created by simon on 23/06/15.
 */
public class Worker implements WorkerFace{

    //There may be a number of ways to connect to the data (NoSQL, File store, SQL, etc...)
   // private DataMachine machine;

    //Using these for better readability...
    public static final int INSERT = 10;
    public static final int READ = 20;
    public static final int UPDATE = 30;


    private DataMachine machine;
    private WorkerRules rules;

    private DataConnection existingConnection;

    /**
     * We want either a directory to scan, or a file list.
     */
    private Worker(){}


    public Worker(WorkerRules r){
        this.rules = r;
        machine = setupMachine(r);

    }

    DataMachine setupMachine(WorkerRules rules){

        //Set up the relevant machine to work from.
        switch (rules.getDataType()) {
            case FILE_STORE:
                machine = new FileStore(rules.getDirectory());
                break;
            case MONGODB:
                machine = new Mongo(new MongoConnection(rules.getMongoDB(), rules.getMongoCollection()));
                break;
            case DATAONE:
                machine = new DataONE();
                break;
        }
        return machine;
    }

    public ActionReport doWork(){
        return doWork(rules.getBatches(),
                rules.getBatchSize(),
                rules.getReadChance(),
                rules.getInsertChance(),
                rules.getUpdateChance());
    }

    private ActionReport doWork(int batches, int batchSize, int rChance, int iChance, int uChance) {

        ActionReport report = new ActionReport();

        List<ActionReport>mesurement = new ArrayList<ActionReport>();

        //Each worker will do a number of batches of work. Each batch is seen as a number of grouped tasks.
        for (int i = 0; i<batches; i++){

            int job = 0;
            boolean success = false;

            machine.begin();  //Mark the start of the batch - this is relevant to some dbs
            for (int n = 0; n<batchSize; n++) {

                job = getJob(rChance,iChance,uChance);
                switch (job) {
                    case INSERT:
                        success = machine.insert(1);
                        break;

                    case READ:
                        success = machine.read(1);
                        break;

                    case UPDATE:
                        success = machine.update(1);
                        break;

                    default:
                        throw new IllegalStateException("'getJob' has returned an Illegal value");
                }

                //Add this record to the action report.
                report.add(job, success);

            }
            machine.commit(); //Mark the end of the batch - this is relevant for some dbs.

        }

        return report;
    }

    /**
     * Decides what role a worker will play... Insert/Updated/Read...
     * @param rChance, iChance, uChance
     * @return
     */

    public int getJob(int rChance, int iChance, int uChance){

        //This sum is checked when the workerRules are put together, so no need to check here.
        int totalChance = rChance+iChance+uChance;

        //pick a random number within that range of the total.
        final int rand1 = ThreadLocalRandom.current() .nextInt(totalChance);

        //Return the fate of this worker...
        if ( rand1< rules.getInsertChance()){
            return INSERT;      //10
        } else
        if (rand1< rules.getInsertChance()+ rules.getReadChance()){
            return READ;        //20
        } else  {
            return UPDATE;      //30
        }
    }
}
