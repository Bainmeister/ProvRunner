package uk.ac.ncl.provrun.worker;

import uk.ac.ncl.provrun.connection.MongoConnection;
import uk.ac.ncl.provrun.dataMachine.DataMachine;
import uk.ac.ncl.provrun.dataMachine.DataONE;
import uk.ac.ncl.provrun.dataMachine.FileStore;
import uk.ac.ncl.provrun.dataMachine.Mongo;
import uk.ac.ncl.provrun.performance.ActionRecord;

import static uk.ac.ncl.provrun.dataMachine.DataType.*;

/**
 * Created by simon on 23/06/15.
 */
public class Worker implements WorkerFace{

    //There may be a number of ways to connect to the data (NoSQL, File store, SQL, etc...)
   // private DataMachine machine;


    private DataMachine machine;


    /**
     * We want either a directory to scan, or a file list.
     */
    private Worker(){}

    /**
     *
     * @param type
     */
    public Worker(WorkerRules rules){

        switch (rules.getDataType()){
            case FILE_STORE : machine = new FileStore(rules.getDirectory());
                break;
            case MONGODB : machine = new Mongo(new MongoConnection(rules.getMongoDB(),rules.getMongoCollection()));
                break;
            case DATAONE : machine = new DataONE();
                break;
        }

    }



    public ActionRecord doWork() {

        return null;
    }

}
