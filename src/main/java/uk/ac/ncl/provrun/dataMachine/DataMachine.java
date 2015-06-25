package uk.ac.ncl.provrun.dataMachine;

import uk.ac.ncl.provrun.performance.ActionRecord;

/**
 * Created by simon on 24/06/15.
 */
public interface DataMachine {

    ActionRecord insert(int n);

    ActionRecord read(int n );

    ActionRecord update(int n);

    ActionRecord begin();

    ActionRecord commit();

}
