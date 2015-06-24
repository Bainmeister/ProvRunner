package uk.ac.ncl.provrun.dataMachine;

import uk.ac.ncl.provrun.connection.MongoConnection;
import uk.ac.ncl.provrun.performance.ActionRecord;

import java.util.List;

/**
 * Created by simon on 24/06/15.
 */
public class Mongo implements DataMachine {

    private MongoConnection connection;

    private Mongo(){}
    public Mongo(MongoConnection connection){
        this.connection = connection;
    }

    public ActionRecord insert(int i){return new ActionRecord();}

    public ActionRecord  read(List<String> k){return new ActionRecord();}

    public ActionRecord  update(List<String> k){return new ActionRecord();}

}
