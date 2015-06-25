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

    private final int minActions;
    private final int maxAxtions;

    private final int batches;
    private final int batchSize;


    //Some rules must not be changed while the object is being used.
    public WorkerRules(int readChance, int insertChance, int updateChance, int minActions, int maxAxtions, int batchNumber, int batchSize){
        this.readChance = readChance;
        this.insertChance = insertChance;
        this.updateChance = updateChance;
        this.totalChance = readChance+insertChance+updateChance;

        this.minActions = minActions;
        this.maxAxtions = maxAxtions;

        this.batches = batchNumber;
        this.batchSize = batchSize;


        //Do some validation

        if (minActions < 0 || maxAxtions <= 0 || minActions > maxAxtions)
            throw new IllegalArgumentException("Check maximum and minimum actions.");

        if (readChance < 0 || insertChance < 0 || updateChance < 0)
            throw new IllegalArgumentException("Chances cannot be less than 0");

        if(totalChance == 0)
            throw new IllegalArgumentException("Chances must sum to greater than 0");

        if (batchNumber<=0 || batchSize <=0)
            throw new IllegalArgumentException("Batch number/size must be greater than 0");
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

    //MAX/MIN ACTIONS
    public int getMinActions() {return minActions;}
    public int getMaxAxtions() {return maxAxtions;}

    //BATCH details
    public int getBatches() {
        return batches;
    }
    public int getBatchSize() {
        return batchSize;
    }
}
