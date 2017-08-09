package startsmart.base.utility.collections;

import java.util.*;

/**
 * Created by sanjeev on 08/08/17.
 */
public final class SetOperation {

    private SetOperation(){
    }

    public static Set<? extends Object> union(Collection<? extends Object>... data){
        Set result = new HashSet();
        if(data == null || data.length < 1)
            return result;
        Arrays.spliterator(data).forEachRemaining(e -> result.addAll(e));
        return result;

    }

    public static Set<? extends Object> intersection(Collection<? extends Object>... data){

        if(data == null || data.length < 1)
            return new HashSet();

        Collection<? extends Object> result = data[0];
        for(int i = 1; i < data.length ; i++){
            result = intersect(result, data[i]);
            if(result.isEmpty())
                return new HashSet<>();
        }
        return new HashSet<>(result);

    }

    public static Set<? extends Object> difference(Collection<? extends Object> a, Collection<? extends Object> b){
        if(a == null || a.isEmpty())
            return new HashSet<>();
        Set result = new HashSet<>(a);
        if(b == null || b.isEmpty())
            return result;
        result.removeAll(b);
        return result;
    }

    private static Set<? extends Object> intersect(Collection<? extends Object> a, Collection<? extends Object> b){
        if(a == null || a.isEmpty() || b == null || b.isEmpty())
            return new HashSet<>();
        Set result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    public static Set reverseDifference(List<Long> a, List<Long> b) {
        return difference(b, a);
    }
}
