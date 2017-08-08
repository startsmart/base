package startsmart.base.utility.system;

import startsmart.base.utility.datetime.DateUtility;

import java.io.PrintStream;

/**
 * Created by sanjeev on 03/08/17.
 */
public class JUtility {

    private JUtility()
    {
    }

    public static void delay(long millis)
    {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void delay(long millis, boolean verbose)
    {
        PrintStream out = verbose ? System.out : null;
        delay(millis, out);
    }

    public static void delay(long millis, PrintStream out)
    {
        try
        {
            if(out != null) threadLog("Waiting for... " + DateUtility.getHumanReadableTime(millis), out);
            Thread.sleep(millis);
            if(out != null) threadLog("Completed waiting.", out);
        }
        catch (Exception e)
        {
            if(out != null)
            {
                threadLog("Exception while waiting. " + e, out);
                throw new RuntimeException(e);
            }
        }
    }

    public static void threadLog(String message)
    {
        threadLog(message, System.out);
    }

    public static void threadLog(String message, PrintStream out)
    {
        String msg = DateUtility.getFormattedCurrentDate("MMM dd yyyy kk:mm:ss:SSS");
        msg += " - ["  + Thread.currentThread().getName();
        msg += "]: "  + message;
        out.println(msg);
    }
}
