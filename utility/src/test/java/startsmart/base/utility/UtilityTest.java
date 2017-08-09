package startsmart.base.utility;

import startsmart.base.utility.collections.SetOperation;
import startsmart.base.utility.datetime.SerialTimer;
import startsmart.base.utility.datetime.Timer;
import startsmart.base.utility.file.FileUtility;
import startsmart.base.utility.system.JUtility;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

/**
 * Created by sanjeev on 28/06/17.
 */
public class UtilityTest
{

    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println(JUtility.extractStringConstantsFromJava("/Users/sanjeev/Documents/mycode/git/startsmart/base/utility/src/main/java/startsmart/base/utility/dateTime/Lap.java"));
    }

    private static void setTest()
    {
        Set t = SetOperation.intersection(Arrays.asList(new Long[]{1L,2L,3L}), Arrays.asList(new Long[]{5L,2L,3L, 6L}),
                Arrays.asList(new Long[]{5L,2L,3L, 4L}), Arrays.asList(new Long[]{2L,3L}));
        System.out.println(t);

        Set u = SetOperation.union(Arrays.asList(new Long[]{1L,2L,3L}), Arrays.asList(new Long[]{5L,2L,3L, 6L}),
                Arrays.asList(new Long[]{5L,2L,3L, 4L}), Arrays.asList(new Long[]{2L,3L}));
        System.out.println(u);

        Set d = SetOperation.difference(Arrays.asList(new Long[]{1L,2L,3L}), Arrays.asList(new Long[]{5L,2L,3L, 6L}));
        System.out.println(d);

        Set rd = SetOperation.reverseDifference(Arrays.asList(new Long[]{1L,2L,3L}), Arrays.asList(new Long[]{5L,2L,3L, 6L}));
        System.out.println(rd);
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
