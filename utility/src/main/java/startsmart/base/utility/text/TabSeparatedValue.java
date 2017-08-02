package startsmart.base.utility.text;

import startsmart.base.constant.StringConstants;

/**
 * Created by sanjeev on 02/08/17.
 */
public class TabSeparatedValue extends QuoteEscapeSV {

    public TabSeparatedValue() {
        this(null);
    }

    public TabSeparatedValue(String emptyValue){
        super(StringConstants.TAB, emptyValue);
    }
}
