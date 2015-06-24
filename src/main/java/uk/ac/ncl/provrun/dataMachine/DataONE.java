package uk.ac.ncl.provrun.dataMachine;

import uk.ac.ncl.provrun.performance.ActionRecord;

import java.util.List;

/**
 * Created by simon on 24/06/15.
 */
public class DataONE implements DataMachine {

    public ActionRecord insert(int i){return new ActionRecord();}

    public ActionRecord  read(List<String> k){return new ActionRecord();}

    public ActionRecord  update(List<String> k){return new ActionRecord();}

}
