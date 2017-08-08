package startsmart.base.utility.datetime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanjeev on 08/08/17.
 */
public class SerialTimer {
   private List<Long> timer;

    public SerialTimer(){
        timer = new ArrayList<>();
    }

    public void newLap() {
        long time = System.currentTimeMillis();
        timer.add(time);
    }

    public long getElapsedTime(){
        checkTimer();
        return System.currentTimeMillis() - timer.get(0);
    }

    public long getTimerDuration(){
        checkTimer();
        return timer.get(timer.size() - 1) - timer.get(0);
    }

    private void checkTimer(){
        if(timer.isEmpty())
            throw new IllegalStateException("Timer not yet started");
    }

    public Lap getLap(int n){
        if(n < 1){
            throw new IndexOutOfBoundsException("Lap number should be positive.Index=" + n);
        }
        if(timer.size() <= n){
            throw new IllegalStateException("Lap " + n +" not yet started");
        }
        Lap lap = new Lap();
        lap.setStartTime(timer.get(n-1));
        lap.setEndTime(timer.get(n));
        return lap;
    }

    @Override
    public String toString() {
        if(timer.isEmpty()){
            return "New Timer";
        }
        else{
            return "Start: " + timer.get(0) + " Last:" + timer.get(timer.size() - 1)
                    + " Duration: " + getTimerDuration() + " Elapsed Time: " + getElapsedTime()
                    +" Total Laps: " + (timer.size() - 1);
        }
    }
}
