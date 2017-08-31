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
        //TODO optimize for linear insertion and resizing
        if (this.head == null) {
            this.head = new Node(value);
        } else {
            add(this.head, new Node(value));
        }
        resetHead();
        resize();
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

    protected void add(Node current, Node newNode) {
        int compare = compare(current, newNode);
        if (compare > 0) {
            addBefore(current, newNode);
        } else if (compare < 0) {
            addAfter(current, newNode);
        }
    }

    protected void addBefore(Node current, Node newNode) {
        int compare;
        if (current.previous() == null || (compare = compare(current.previous(), newNode)) < 0) {
            current.addBefore(newNode);
        } else if (compare > 0) {
            addBefore(current.previous(), newNode);
        }
    }

    protected void addAfter(Node current, Node newNode) {
        int compare;
        if (current.next() == null || (compare = compare(current.next(), newNode)) > 0) {
            current.addAfter(newNode);
        } else if (compare < 0) {
            addAfter(current.next(), newNode);
        }
    }

    protected void resize() {
        int tDepth = 1;
        Node current = this.head;
        while (tDepth < this.maxSize) {
            if (current.next() == null) {
                break;
            } else {
                tDepth++;
                current = current.next();
            }
        }
        this.tail = current;
        this.tail.setNext(null);
        this.size = tDepth;
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
