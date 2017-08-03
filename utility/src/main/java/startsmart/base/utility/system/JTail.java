package startsmart.base.utility.system;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by sanjeev on 03/08/17.
 */
public class JTail {

    private static final int DEFAULT_N = 10;
    private static final long SLEEP_TIME = 5000L;

    private static void tail(String path, String... filters) throws IOException {

        String currentLine;
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){

            while (true) {
                if((currentLine = reader.readLine()) != null && filter(currentLine, filters)) {
                    System.out.println(currentLine);
                }
                JUtility.delay(SLEEP_TIME);
            }

        }
    }

    private static boolean filter(String currentLine, String[] filters) {
        if(filters == null || filters.length == 0)
            return true;
        for (String filter : filters) {
            if(currentLine.contains(filter))
                return true;
        }
        return false;
    }


}
