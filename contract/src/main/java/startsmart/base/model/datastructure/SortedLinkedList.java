package startsmart.base.model.datastructure;

/**
 * Created by sanjeev on 30/08/17.
 */
public class SortedLinkedList<T extends Comparable> extends SortedLinkedData<T> {

    public SortedLinkedList(int size) {
        super(size);
    }

    @Override
    protected int compare(Node<T> a, Node<T> b) {
      int val = a.getValue().compareTo(b.getValue());
      return val <=0 ? -1 : 1;
    }
}
