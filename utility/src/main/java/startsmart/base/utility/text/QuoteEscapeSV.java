package startsmart.base.utility.text;

import startsmart.base.constant.StringConstants;

/**
 * Created by sanjeev on 02/08/17.
 */
 public class QuoteEscapeSV extends SeparatedValue {

     private String emptyValue;

    public QuoteEscapeSV(String colSeparator){
        this(colSeparator, null);
    }

    public QuoteEscapeSV(String colSeparator, String emptyValue) {
        super(colSeparator, System.lineSeparator());
    }

    @Override
    protected String escape(Object data) {
        if(data == null)
            return emptyValue;
        String str = String.valueOf(data);
        if(str.isEmpty())
            return emptyValue;
        if(str.contains(StringConstants.COMMA) || str.contains(System.lineSeparator())){
            return StringConstants.QUOTE + str + StringConstants.QUOTE;
        }
        return emptyValue;
    }
}
