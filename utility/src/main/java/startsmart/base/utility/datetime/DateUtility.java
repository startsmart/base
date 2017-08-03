package startsmart.base.utility.datetime;

import startsmart.base.constant.DateTimeConstants;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sanjeev on 03/08/17.
 */
public final class DateUtility {

    private DateUtility()
    {
    }

    public static long getDaysElapsed(Date startDate, Date endDate)
    {
        long startMillis = startDate.getTime();
        long endMillis = endDate.getTime();
        long diff = Math.abs(endMillis - startMillis);
        long daysElapsed = Math.round(diff / DateTimeConstants.MILLI_SEC_IN_A_DAY);
        return daysElapsed;
    }

    public static long getWeeksElapsed(Date startDate, Date endDate)
    {
        long weeksElapsed = Math.round(getDaysElapsed(startDate, endDate) / DateTimeConstants.DAYS_IN_WEEK);
        return weeksElapsed;
    }

    public static String getMonthIdentifier(Date date)
    {
        SimpleDateFormat format = new SimpleDateFormat("MMM_yyyy");
        return format.format(date).toUpperCase();
    }

    public static String getDateIdentifier(Date date)
    {
        SimpleDateFormat format = new SimpleDateFormat("dd_MMM_yyyy");
        return format.format(date).toUpperCase();
    }

    public static String getFormattedCurrentDate(String formatStr)
    {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return format.format(new Date()).toUpperCase();
    }

    public static String getHumanReadableTime(long millis)
    {
        String time = "";
        if(millis > DateTimeConstants.MILLI_SEC_IN_A_DAY)
        {
            long temp = millis %  DateTimeConstants.MILLI_SEC_IN_A_DAY;
            time += ((millis - temp) / DateTimeConstants.MILLI_SEC_IN_A_DAY) + " Day(s) ";
            millis = temp;
        }
        if(millis > DateTimeConstants.MILLI_SEC_IN_A_HOUR)
        {
            long temp = millis %  DateTimeConstants.MILLI_SEC_IN_A_HOUR;
            time += ((millis - temp) / DateTimeConstants.MILLI_SEC_IN_A_HOUR) + " Hour(s) ";
            millis = temp;
        }
        if(millis > DateTimeConstants.MILLI_SEC_IN_A_MINUTE)
        {
            long temp = millis %  DateTimeConstants.MILLI_SEC_IN_A_MINUTE;
            time += ((millis - temp) / DateTimeConstants.MILLI_SEC_IN_A_MINUTE) + " Min(s) ";
            millis = temp;
        }
        if(millis > DateTimeConstants.MILLI_SEC_IN_A_SEC)
        {
            long temp = millis %  DateTimeConstants.MILLI_SEC_IN_A_SEC;
            time += ((millis - temp) / DateTimeConstants.MILLI_SEC_IN_A_SEC) + " Sec(s) ";
            millis = temp;
        }
        if(millis > 0)
        {
            time += millis + " MilliSec(s) ";
        }
        return time;
    }
}
