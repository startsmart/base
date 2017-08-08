package startsmart.base.utility;

import startsmart.base.utility.datetime.SerialTimer;
import startsmart.base.utility.datetime.Timer;
import startsmart.base.utility.system.JUtility;

/**
 * Created by sanjeev on 28/06/17.
 */
public class UtilityTest
{

    public static void main(String[] args) throws InterruptedException {
        SerialTimer st = new SerialTimer();
        st.newLap();
        st.newLap();
        st.newLap();
        st.newLap();
        st.newLap();
        st.newLap();

        for (int i = 1; i<= 5; i++){
            System.out.println("Lap-" + i + " -> " + st.getLap(i));
        }
        System.out.println(st);
    }

    private static void serialTimerTest(){
        SerialTimer st = new SerialTimer();
        st.newLap();
        for(int i = 1; i <= 9; i++){
            JUtility.delay(5000);
            st.newLap();
        }
        for (int i = 1; i<= 9; i++){
            System.out.println("Lap-" + i + " -> " + st.getLap(i));
        }
        System.out.println(st);
    }
    private static void timerTest(){
        Timer timer = new Timer();
        timer.start();
        timer.startLap("Lap-0");
        int i=1;
        for(; i <=9; i++){
            JUtility.delay(5000L);
            timer.endLap("Lap-" + (i-1));
            timer.startLap("Lap-" + i);
        }
        JUtility.delay(5000L);
        timer.endLap("Lap-" + (i-1));
        timer.stop();
        System.out.println(timer);
    }

}
