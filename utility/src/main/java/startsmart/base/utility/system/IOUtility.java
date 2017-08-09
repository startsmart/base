package startsmart.base.utility.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by sanjeev on 09/08/17.
 */
public final class IOUtility {

    private IOUtility(){
    }

    public static String getDataFromInputStream(InputStream is) throws IOException
    {
        StringBuilder builder = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(is));)
        {
            char[] buffer = new char[5120];
            while (reader.read(buffer) != -1)
            {
                builder.append(buffer);
                JUtility.delay(100);
            }
        }
        return builder.toString();
    }
}
