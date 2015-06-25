package uk.ac.ncl.provrun.dataMachine;

import uk.ac.ncl.provrun.connection.MongoConnection;

/**
 * Created by simon on 24/06/15.
 */
public class Mongo implements DataMachine {

    private MongoConnection connection;

    private Mongo(){}
    public Mongo(MongoConnection connection) {
        this.connection = connection;
    }

    public boolean insert(int n){
        return true;
    }

    public boolean read(int n){
        return true;
    }

    public boolean update(int n){
        return true;
    }

    public boolean begin() {
        return true;
    }

    public boolean commit() {
        return true;
    }

}
