package utility.file;

import java.io.*;

/**
 * Created by sanjeev on 25/07/17.
 */
public class CSVReader<T> extends SVReader<T> {

    public CSVReader(ToPOJO<T> converter) {
        super(System.lineSeparator(), ",", converter);
    }
}
