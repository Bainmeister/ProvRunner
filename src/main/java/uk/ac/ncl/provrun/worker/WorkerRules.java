package uk.ac.ncl.provrun.worker;

/**
 * Created by simon on 24/06/15.
 */
public class WorkerRules {


    private String directory;

    private String mongoDB;

    private String mongoCollection;

    private int dataType;


    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getMongoDB() {
        return mongoDB;
    }

    public void setMongoDB(String mongoDB) {
        this.mongoDB = mongoDB;
    }

    public String getMongoCollection() {
        return mongoCollection;
    }

    public void setMongoCollection(String mongoCollection) {
        this.mongoCollection = mongoCollection;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }
}
