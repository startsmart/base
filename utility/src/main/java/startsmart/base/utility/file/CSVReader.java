package startsmart.base.utility.file;

import startsmart.base.contract.general.ToPOJO;

/**
 * Created by sanjeev on 25/07/17.
 */
public class CSVReader<T> extends SVReader<T> {

    public CSVReader(ToPOJO<T> converter) {
        super(System.lineSeparator(), ",", converter);
    }
}
