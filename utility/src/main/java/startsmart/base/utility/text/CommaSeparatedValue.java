package startsmart.base.utility.text;

import startsmart.base.constant.StringConstants;

/**
 * Created by sanjeev on 02/08/17.
 */
public class CommaSeparatedValue extends QuoteEscapeSV {

    public CommaSeparatedValue(){
        this(null);
    }

    public CommaSeparatedValue(String emptyValue){
        super(StringConstants.COMMA, emptyValue);
    }
}
