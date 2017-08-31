package startsmart.base.model.datastructure;

/**
 * Created by sanjeev on 30/08/17.
 */
public class Node<T> {

    private Node previous;
    private T value;
    private Node next;

    public Node(T value){
        this.value = value;
    }

    public Node previous() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node next() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void addBefore(Node node){
        checkCyclicInsertion(node);
        node.previous = this.previous;
        node.next = this;
        this.previous = node;
        if(node.previous != null){
            node.previous.next = node;
        }
    }

    public void addAfter(Node node){
        checkCyclicInsertion(node);
        node.next = this.next;
        node.previous = this;
        this.next = node;
        if(node.next != null){
            node.next.previous = node;
        }
    }

    private void checkCyclicInsertion(Node node){
        if(node == this){
            throw new IllegalStateException("Cyclic Insertion : this node cannot be added as pointer to the same node");
        }
    }
}
