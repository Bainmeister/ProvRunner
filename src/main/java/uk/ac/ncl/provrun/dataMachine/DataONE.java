package uk.ac.ncl.provrun.dataMachine;

import uk.ac.ncl.provrun.performance.ActionRecord;

/**
 * Created by simon on 24/06/15.
 */
public class DataONE implements DataMachine {

    //TODO
    public ActionRecord insert(int n){
        return new ActionRecord();
    }

    public ActionRecord  read(int n){
        return new ActionRecord();
    }

    public ActionRecord  update(int n){
        return new ActionRecord();
    }

    public ActionRecord begin() {
        return null;
    }

    public ActionRecord commit() {
        return null;
    }


}
