package startsmart.base.constant;

/**
 * Created by sanjeev on 02/08/17.
 */
public final class DateTimeConstants {

    private DateTimeConstants(){
    }

    public static long MILLI_SEC_IN_A_DAY = 86400000L;
    public static long MILLI_SEC_IN_A_HOUR = 3600000L;
    public static long MILLI_SEC_IN_A_MINUTE = 60000L;
    public static long MILLI_SEC_IN_A_SEC = 1000L;

    public static long SEC_IN_A_DAY = 86400L;
    public static long SEC_IN_A_HOUR = 3600L;
    public static long SEC_IN_A_MINUTE = 60L;

    public static long MINUTE_IN_A_DAY = 1440L;
    public static long MINUTE_IN_A_HOUR = 60L;

    public static long HOUR_IN_A_DAY = 24L;

    public static long DAYS_IN_WEEK = 7L;

    private static long[] DAYS_IN_MONTH = {29,31,28,31,30,31,30,31,31,30,31,30,31};

    public static final long DAYS_IN_FEB_LEAP = DAYS_IN_MONTH[0];
    public static final long DAYS_IN_JAN = DAYS_IN_MONTH[1];
    public static final long DAYS_IN_FEB = DAYS_IN_MONTH[2];
    public static final long DAYS_IN_MAR = DAYS_IN_MONTH[3];
    public static final long DAYS_IN_APR = DAYS_IN_MONTH[4];
    public static final long DAYS_IN_MAY = DAYS_IN_MONTH[5];
    public static final long DAYS_IN_JUN = DAYS_IN_MONTH[6];
    public static final long DAYS_IN_JUL = DAYS_IN_MONTH[7];
    public static final long DAYS_IN_AUG = DAYS_IN_MONTH[8];
    public static final long DAYS_IN_SEP = DAYS_IN_MONTH[9];
    public static final long DAYS_IN_OCT = DAYS_IN_MONTH[10];
    public static final long DAYS_IN_NOV = DAYS_IN_MONTH[11];
    public static final long DAYS_IN_DEC = DAYS_IN_MONTH[12];
}
