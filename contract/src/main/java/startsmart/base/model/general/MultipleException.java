package startsmart.base.model.general;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sanjeev on 07/08/17.
 */
public class MultipleException extends RuntimeException{

    private Object returnData;
    private List<Exception> exceptions;

    public MultipleException(Exception... e){
        if(e == null)
        {
            throw new InvalidParameterException("Exceptions cannot be null");
        }
        this.exceptions = new ArrayList(Arrays.asList(e));
    }

    public MultipleException(List<Exception> e){
        if(e == null || e.isEmpty()){
            throw new InvalidParameterException("Exceptions cannot be null");
        }
        this.exceptions = e;
    }

    public List<Exception> getExceptions() {
        return exceptions;
    }

    @Override
    public String getMessage() {
        StringBuilder builder = new StringBuilder();
        exceptions.forEach(e -> builder.append(String.valueOf(e.getMessage()) + System.lineSeparator()));
        return builder.toString();
    }

    public List<String> getMessages(){
        List<String> messages = new ArrayList<>();
        exceptions.forEach(e -> messages.add(e.getMessage()));
        return messages;
    }

    public void setReturnData(Object returnData) {
        this.returnData = returnData;
    }

    public Object getReturnData() {
        return returnData;
    }
}
