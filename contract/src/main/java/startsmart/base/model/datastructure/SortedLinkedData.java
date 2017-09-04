package startsmart.base.model.datastructure;

/**
 * Created by sanjeev on 30/08/17.
 */
public abstract class SortedLinkedData<T extends Comparable>{

    private Node<T> head;
    private int maxSize;
    private Node<T> tail;
    private int size = 0;

    public SortedLinkedData(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size should be positive");
        }
        this.maxSize = size;
    }

    public void insert(T value) {
        if (this.head == null) {
            this.head = new Node(value);
            this.tail = this.head;
            this.size++;
        } else {
            add(new Node(value));
            resize();
        }
    }

    public T getHeadValue() {
        if (this.head == null) {
            throw new IllegalStateException("Empty set");
        }
        return this.head.getValue();
    }

    public T getTailValue() {
        if (this.tail == null) {
            throw new IllegalStateException("Empty set");
        }
        return this.tail.getValue();
    }

    public T getValue(int index) {
        if (index < 1 && index > this.maxSize) {
            throw new IndexOutOfBoundsException("Range 1 - " + this.maxSize + " Index -" + index);
        }
        if (index == 1) {
            return getHeadValue();
        }
        if (index == this.maxSize) {
            return getTailValue();
        }
        return getNNode(index).getValue();
    }

    protected void add(Node<T> newNode){
        int tCompare = compare(tail, newNode);
        if(tCompare > 0){
            this.add(this.head, newNode);
        } else if(tCompare != 0 && this.size < this.maxSize) {
            linkAfter(tail, newNode);
        }
    }

    protected void add(Node<T> current, Node<T> newNode) {
        int compare = compare(current, newNode);
        if (compare > 0) {
            addBefore(current, newNode);
        } else if (compare < 0) {
            addAfter(current, newNode);
        }
    }

    protected void addBefore(Node<T> current, Node<T> newNode) {
        int compare;
        if (current.previous() == null || (compare = compare(current.previous(), newNode)) < 0) {
            linkBefore(current, newNode);
        } else if (compare > 0) {
            addBefore(current.previous(), newNode);
        }
    }

    protected void addAfter(Node<T> current, Node<T> newNode) {
        int compare;
        if (current.next() == null || (compare = compare(current.next(), newNode)) > 0) {
            linkAfter(current, newNode);
        } else if (compare < 0) {
            addAfter(current.next(), newNode);
        }
    }

    protected void linkBefore(Node<T> current, Node<T> newNode){
        newNode.setPrevious(current.previous());
        newNode.setNext(current);
        current.setPrevious(newNode);
        if(newNode.previous() != null){
            newNode.previous().setNext(newNode);
        }
        if(current == head){
            head = newNode;
        }
        this.size++;
    }

    protected void linkAfter(Node<T> current, Node<T> newNode){
        newNode.setNext(current.next());
        newNode.setPrevious(current);
        current.setNext(newNode);
        if(newNode.next() != null){
            newNode.next().setPrevious(newNode);
        }
        if(current == tail){
            tail = newNode;
        }
        this.size++;
    }


    protected void resize() {
        if(this.size > this.maxSize){
            Node current = this.tail;
            this.tail = current.previous();
            this.tail.setNext(null);
            current.setNext(null);
            current.setPrevious(null);
            this.size--;
        }
    }

    protected void resetHead() {
        while (this.head.previous() != null) {
            this.head = this.head.previous();
        }
    }

    protected Node<T> getNNode(int index) {
        int rDistance = (this.size - index) + 1;
        return index <= rDistance ? traverseHead(index) : traverseTail(rDistance);
    }

    protected Node<T> traverseHead(int index) {
        Node current = this.head;
        for (int i = 1; i < index; i++) {
            current = current.next();
        }
        return current;
    }

    protected Node<T> traverseTail(int index) {
        Node current = this.tail;
        for (int i = 1; i < index; i++) {
            current = current.previous();
        }
        return current;
    }

    protected abstract int compare(Node<T> a, Node<T> b);

    @Override
    public String toString() {
        if (this.head == null)
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Node current = this.head;
        while (current != null) {
            sb.append(current.getValue());
            if (current.next() == null) {
                return sb.append(']').toString();
            } else {
                sb.append(',').append(' ');
                current = current.next();
            }
        }
        return sb.toString();
    }


    public String headTraverse() {
        return toString();
    }

    public String tailTraverse() {
        if (this.tail == null)
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Node current = this.tail;
        while (current != null) {
            sb.append(current.getValue());
            if (current.previous() == null) {
                return sb.append(']').toString();
            } else {
                sb.append(',').append(' ');
                current = current.previous();
            }
        }
        return sb.toString();
    }

    public int size() {
        return this.size;
    }
}
