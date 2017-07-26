package startsmart.base.utility.type;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by sanjeev on 26/07/17.
 */
public final class Converter {

    private Converter() {
    }

    public static Byte optByte(String s, Byte optional) {
        try {
            return Byte.parseByte(s);
        } catch (Exception e) {
            return optional;
        }
    }

    public static byte optbyte(String s, byte optional) {
        return optByte(s, optional).byteValue();
    }


    public static Short optShort(String s, Short optional) {
        try {
            return Short.parseShort(s);
        } catch (Exception e) {
            return optional;
        }
    }

    public static short optshort(String s, short optional) {
        return optShort(s, optional).shortValue();
    }


    public static Integer optInteger(String s, Integer optional) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return optional;
        }
    }

    public static int optInt(String s, int optional) {
        return optInteger(s, optional).intValue();
    }

    public static Long optLong(String s, Long optional) {
        try {
            return Long.parseLong(s);
        } catch (Exception e) {
            return optional;
        }
    }

    public static long optlong(String s, long optional) {
        return optLong(s, optional).longValue();
    }

    public static Float optFloat(String s, Float optional) {
        try {
            return Float.parseFloat(s);
        } catch (Exception e) {
            return optional;
        }
    }

    public static float optfloat(String s, float optional) {
        return optFloat(s, optional).floatValue();
    }

    public static Double optDouble(String s, Double optional) {
        try {
            return Double.parseDouble(s);
        } catch (Exception e) {
            return optional;
        }
    }

    public static double optdouble(String s, double optional) {
        return optDouble(s, optional).doubleValue();
    }

    public static BigInteger optBigInteger(String s, BigInteger optional) {
        try {
            return new BigInteger(s);
        } catch (Exception e) {
            return optional;
        }
    }

    public static BigDecimal optBigDecimal(String s, BigDecimal optional) {
        try {
            return new BigDecimal(s);
        } catch (Exception e) {
            return optional;
        }
    }
}
