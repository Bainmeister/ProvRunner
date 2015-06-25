package uk.ac.ncl.provrun.performance;

import uk.ac.ncl.provrun.worker.Worker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simon on 24/06/15.
 */
public class ActionReport {

    private List<Integer> jobsDone;
    private List<Boolean> successful;

    public ActionReport(){
        jobsDone = new ArrayList<Integer>();
        successful = new ArrayList<Boolean>();
    }


    public void add(int job, boolean success) {
        jobsDone.add(job);
        successful.add(success);
    }

    public void getReport(){

        int insert = 0, read = 0, update = 0;
        int success = 0, failure = 0;

        for(int job : jobsDone){
            switch (job){
                case Worker.INSERT : insert++;  break;
                case Worker.UPDATE : update++;  break;
                case Worker.READ : read++;  break;
            }
        }

        for(boolean succeded : successful){
             int x=succeded ? success++ : failure++;
        }

        System.out.println("Successful: " + success);
        System.out.println("Failures: " + failure);
        System.out.println("INSERTS: " + insert + " READS: " + read + " UPDATES: " + update );

    }

}
