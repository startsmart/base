package startsmart.base.model.datastructure;

/**
 * Created by sanjeev on 30/08/17.
 */
public class ReverseSortedLinkedSet<T extends Comparable> extends SortedLinkedData<T> {

    public ReverseSortedLinkedSet(int size) {
        super(size);
    }

    @Override
    protected int compare(Node<T> a, Node<T> b) {
      return b.getValue().compareTo(a.getValue());
    }
}
