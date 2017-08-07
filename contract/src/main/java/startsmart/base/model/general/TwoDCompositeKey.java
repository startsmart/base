package startsmart.base.model.general;

/**
 * Created by sanjeev on 07/08/17.
 */
public class TwoDCompositeKey<K1, K2> {

    private K1 key1;
    private K2 key2;

    public TwoDCompositeKey(K1 key1Arg, K2 key2Arg)
    {
        key1 = key1Arg;
        key2 = key2Arg;
    }

    /**
     * @return the key1
     */
    public K1 getKey1()
    {
        return key1;
    }

    /**
     * @return the key2
     */
    public K2 getKey2()
    {
        return key2;
    }

    @Override
    public int hashCode()
    {
        int hashCode = 0;
        if(key1 != null)
        {
            hashCode += key1.hashCode();
        }
        if(key2 != null)
        {
            hashCode += key2.hashCode();
        }
        return hashCode;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null) return false;
        if(this == obj) return true;
        if(obj instanceof TwoDCompositeKey)
        {
            TwoDCompositeKey<?,?> oKey = (TwoDCompositeKey<?,?>) obj;
            boolean check1 = checkKeyEquals(this.key1, oKey.key1);
            boolean check2 = checkKeyEquals(this.key2, oKey.key2);
            return (check1 && check2);
        }
        return false;
    }

    private static boolean checkKeyEquals(Object thisKey, Object otherKey)
    {
        if(thisKey == otherKey) return true;
        if(thisKey == null)  return (otherKey == null);
        return thisKey.equals(otherKey);
    }

    @Override
    public String toString()
    {
        String str = "null";
        if(key1 != null)
        {
            str = key1.toString();
        }
        if(key2 != null)
        {
            str += "\t" + key2.toString();
        }
        return str;
    }
}
