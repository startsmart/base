package utility.file;

import java.util.Map;

/**
 * Created by sanjeev on 25/07/17.
 */
public interface ToPOJO<T> {

    public T convert(String[] data);
    public  T convert(String[] data, Map<String, Integer> headerPositionMap);
}
