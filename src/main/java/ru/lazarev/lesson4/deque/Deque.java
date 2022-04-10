package ru.lazarev.lesson4.deque;


import ru.lazarev.lesson4.queue.Queue;

public interface Deque<E> extends Queue<E> {

    boolean insertLeft(E value);
    boolean insertRight(E value);

    E removeLeft();
    E removeRight();

    class Node<E> {
        public E value;
        public Node<E> next;
        public Node<E> last;

        public Node(E value, Node<E> next, Node<E> last) {
            this.value = value;
            this.next = next;
            this.last = last;
        }
    }
}
