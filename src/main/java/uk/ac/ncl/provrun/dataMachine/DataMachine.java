package uk.ac.ncl.provrun.dataMachine;

import uk.ac.ncl.provrun.performance.ActionRecord;
import java.util.List;

/**
 * Created by simon on 24/06/15.
 */
public interface DataMachine {

    ActionRecord insert(int i);

    ActionRecord read(List<String> k);

    ActionRecord update(List<String> k);

}
