package startsmart.base.model.datastructure;

/**
 * Created by sanjeev on 30/08/17.
 */
public class SortedLinkedSet<T extends Comparable> extends SortedLinkedData<T> {

    public SortedLinkedSet(int size) {
        super(size);
    }

    @Override
    protected int compare(Node<T> a, Node<T> b) {
      return a.getValue().compareTo(b.getValue());
    }
}
