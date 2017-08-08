package startsmart.base.utility.datetime;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by sanjeev on 08/08/17.
 */
public class Timer {

    private Lap mainLap;
    private Map<String, Lap> intermediateLaps;

    public Timer(){
        this.mainLap = new Lap();
        this.intermediateLaps = new TreeMap<>();
    }

    public void start(){
        this.mainLap.start();
    }

    public void stop(){
        this.mainLap.stop();
    }

    public void startLap(String lapKey){
        long start = System.currentTimeMillis();
        if(intermediateLaps.containsKey(lapKey)){
            throw new IllegalArgumentException("Lap already started for " + lapKey);
        }
        if(mainLap.isClosed()){
            throw new IllegalStateException("Timer is closed. Cannot lap on a closed Timer.");
        }
        Lap lap = new Lap();
        lap.setStartTime(start);
        intermediateLaps.put(lapKey, lap);
    }

    public void endLap(String lapKey){
        long end = System.currentTimeMillis();
        checkLapKey(lapKey);
        Lap lap = intermediateLaps.get(lapKey);
        lap.setEndTime(end);
        intermediateLaps.put(lapKey, lap);
    }

    public Lap getLap(String lapKey){
        checkLapKey(lapKey);
        return intermediateLaps.get(lapKey);
    }

    public long getElapsedTime(){
       return mainLap.getElapsedTime();
    }

    public long getElapsedTime(String lapKey){
        return getLap(lapKey).getElapsedTime();
    }

    public Map<String, Long> getElapsedLapsTime(){
        Map<String, Long> time = new TreeMap<>();
        intermediateLaps.forEach((key, value) -> time.put(key, value.getElapsedTime()));
        return time;
    }

    private void checkLapKey(String lapKey) {
        if(!intermediateLaps.containsKey(lapKey)){
            throw new IllegalArgumentException("No Lap found for " + lapKey);
        }

    }

    @Override
    public String toString() {
        if(mainLap.isStarted()){
            StringBuilder to = new StringBuilder(mainLap.toString());
            intermediateLaps.forEach((key, value) -> to.append(System.lineSeparator() + key + " -> " + value.toString()));
            return to.toString();
        }
        return  "New Timer";
    }
}
