package ru.lazarev.lesson6.three;

public interface Tree<E extends Comparable<? super E>> {

    boolean isBalanced(Node<?> node);

    boolean isBalanced();

    enum TraversMode {
        IN_ORDER, PRE_ORDER, POST_ORDER
    }

    boolean contains(E value);

    boolean add(E value);

    boolean remove(E value);

    boolean isEmpty();

    int size();

    void display();

    void traverse(TraversMode mode);

}
