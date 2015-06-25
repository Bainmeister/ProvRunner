package uk.ac.ncl.provrun.worker;

import uk.ac.ncl.provrun.connection.MongoConnection;
import uk.ac.ncl.provrun.dataMachine.DataMachine;
import uk.ac.ncl.provrun.dataMachine.DataONE;
import uk.ac.ncl.provrun.dataMachine.FileStore;
import uk.ac.ncl.provrun.dataMachine.Mongo;
import uk.ac.ncl.provrun.performance.ActionRecord;

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


    /**
     * We want either a directory to scan, or a file list.
     */
    private Worker(){}

    /**
     *
     * @param ruleset
     */

    //TODO - it is possible that we are using the same data connection across multiple worker, create a constructor that reflects this.

    public Worker(WorkerRules ruleset){

        this.rules = ruleset;

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
    }

    public ActionRecord doWork(){
        return doWork(rules.getBatches(),
                rules.getBatchSize(),
                rules.getReadChance(),
                rules.getInsertChance(),
                rules.getUpdateChance());
    }

    private ActionRecord doWork(int batches, int batchSize, int rChance, int iChance, int uChance) {

        ActionRecord record = new ActionRecord();

        //TODO actually use ActionRecord!
        //Each worker will do a number of batches of work. Each batch is seen as a number of grouped tasks.
        for (int i = 0; i<batches; i++){

            machine.begin();  //Mark the start of the batch - this is relevant to some dbs
            for (int n = 0; n<batchSize; n++) {
                switch (getJob(rChance,iChance,uChance)) {
                    case INSERT: machine.insert(1);
                    case READ:   machine.read(1);
                    case UPDATE: machine.update(1);
                    default:
                        throw new IllegalStateException("'getJob' has returned an Illegal value");
                }
            }
            machine.commit(); //Mark the end of the batch - this is relevant for some dbs.
        }

        return record;
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
