package uk.ac.ncl.provrun.worker;

import uk.ac.ncl.provrun.connection.MongoConnection;
import uk.ac.ncl.provrun.dataMachine.DataMachine;
import uk.ac.ncl.provrun.dataMachine.DataONE;
import uk.ac.ncl.provrun.dataMachine.FileStore;
import uk.ac.ncl.provrun.dataMachine.Mongo;
import uk.ac.ncl.provrun.performance.ActionRecord;

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
    public static final int INSERTER = 10;
    public static final int READER = 20;
    public static final int UPDATER = 30;


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



    public ActionRecord doWork() {

        switch (getJob(rules.getTotalChance())){
            case INSERTER : return machine.insert(getInsertCount());
            case READER : return machine.read(getKeys());
            case UPDATER : return machine.update(getKeys());
            default : throw new IllegalStateException("'getJob' has returned an Illegal value");
        }

    }

    /**
     * Decides what role a worker will play... Insert/Updated/Read...
     * @param totalChance
     * @return
     */

    public int getJob(int totalChance){

        //pick a random number within that range of the total.
        final int rand1 = ThreadLocalRandom.current() .nextInt(totalChance);

        //Return the fate of this worker...
        if ( rand1< rules.getInsertChance()){
            return INSERTER;
        } else
        if (rand1< rules.getInsertChance()+ rules.getReadChance()){
            return READER;      //20
        } else  {
            return UPDATER;     //30
        }
    }
    
    public List<String> getKeys(){
        return null;
    }

    public Integer getInsertCount(){
        return null;
    }

}
