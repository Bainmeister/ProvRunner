package uk.ac.ncl.provrun.dataMachine;

/**
 * Created by simon on 24/06/15.
 */
public interface DataMachine {

    boolean insert(int n);

    boolean read(int n);

    boolean update(int n);

    boolean begin();

    boolean commit();

}
