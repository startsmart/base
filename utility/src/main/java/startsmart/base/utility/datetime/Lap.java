package startsmart.base.utility.datetime;

/**
 * Created by sanjeev on 08/08/17.
 */
public class Lap {

    private Long startTime;
    private Long endTime;


    public long getStartTime() {
        checkStart();
        return startTime;
    }

    public void start() {
        long start = System.currentTimeMillis();
        setStartTime(start);
    }

    public void setStartTime(long start){
        checkClosed();
        this.startTime = start;
    }

    public long getEndTime() {
        checkStop();
        return endTime;
    }

    public void stop() {
        long end = System.currentTimeMillis();
        setEndTime(end);
    }

    public void setEndTime(long end){
        checkStart();
        checkClosed();
        this.endTime = end;
    }

    public long getElapsedTime(){
        checkStart();
        checkStop();
        return getEndTime() - getStartTime();
    }

    public boolean isClosed(){
        return endTime != null;
    }

    public boolean isStarted(){
        return startTime != null;
    }

    private void checkStart(){
        if(startTime == null)
            throw new IllegalStateException("Lap not yet started.");
    }

    private void checkStop(){
        if(endTime == null)
            throw new IllegalStateException("Lap not yet stopped.");
    }

    private void checkClosed(){
        if(endTime != null)
            throw new IllegalStateException("Lap Closed.");
    }

    @Override
    public String toString() {
        if(isClosed()){
            return "S:" + getStartTime() + " E:" + getEndTime() + " ET:" + getElapsedTime();
        }
        return  isStarted() ? ("Lap Started @ " + getStartTime()) :  "New Lap";
    }
}
