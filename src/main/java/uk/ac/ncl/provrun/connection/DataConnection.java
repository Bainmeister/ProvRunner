package uk.ac.ncl.provrun.connection;

/**
 * Created by simon on 23/06/15.
 */
public interface DataConnection<T> {

    boolean connect();

    boolean disconnect();

}
