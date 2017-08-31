package startsmart.base.model.datastructure;

/**
 * Created by sanjeev on 30/08/17.
 */
public class ReverseSortedLinkedList<T extends Comparable> extends SortedLinkedData<T> {

    public ReverseSortedLinkedList(int size) {
        super(size);
    }

    @Override
    protected int compare(Node<T> a, Node<T> b) {
      int val = b.getValue().compareTo(a.getValue());
      return val <=0 ? -1 : 1;
    }
}
