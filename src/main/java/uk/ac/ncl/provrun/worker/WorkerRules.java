package uk.ac.ncl.provrun.worker;

/**
 * Created by simon on 24/06/15.
 */
public class WorkerRules {


    private String directory;

    private String mongoDB;

    private String mongoCollection;

    private int dataType;

    //The possibility of doing one or the other... must sum to exactly 100.
    private final int readChance;
    private final int insertChance;
    private final int updateChance;
    private final int totalChance;


    //Some rules must not be changed while the object is being used.
    public WorkerRules(int readChance, int insertChance, int updateChance){
        this.readChance = readChance;
        this.insertChance = insertChance;
        this.updateChance = updateChance;
        this.totalChance = readChance+insertChance+updateChance;
    }

    //READ chance
    public int getReadChance() {return readChance;}

    //INSERT chance
    public int getInsertChance() {return insertChance;}

    //UPDATE chance
    public int getUpdateChance() {return updateChance;}

    //TOTAL chance
    public int getTotalChance() {return totalChance;}

    //DIRECTORY
    public String getDirectory() {
        return directory;
    }
    public void setDirectory(String directory) {
        this.directory = directory;
    }

    //MONGODB
    public String getMongoDB() { return mongoDB; }
    public void setMongoDB(String mongoDB) {
        this.mongoDB = mongoDB;
    }

    //MONGO COLLECTION
    public String getMongoCollection() {
        return mongoCollection;
    }
    public void setMongoCollection(String mongoCollection) {
        this.mongoCollection = mongoCollection;
    }

    //DATA TYPE
    public int getDataType() {
        return dataType;
    }
    public void setDataType(int dataType) {
        this.dataType = dataType;
    }
}
