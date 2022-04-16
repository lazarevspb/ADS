package ru.lazarev.lesson4.deque.impl;

import ru.lazarev.lesson4.deque.Deque;

import java.util.Iterator;


public class LinkedDequeImpl<E> implements Deque<E>, Iterable<E> {

    Deque.Node<E> last;
    Deque.Node<E> first;
    int size;


    @Override
    public boolean insertLeft(E value) {
        if (isEmpty()) {
            first = last = new Deque.Node<>(value, first, last);
            size++;
            return true;
        }


        first.last = new Deque.Node<>(value, first, null);
        first = first.last;

        size++;
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        if (isEmpty()) {
            first = last = new Deque.Node<>(value, first, last);
            size++;
            return true;
        }
        last.next = new Deque.Node<>(value, null, last);
        last = last.next;
        size++;
        return true;

    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }
        E removed = first.value;
        first = first.next;
        size--;

        return removed;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }
        E removed = last.value;
        last = last.last;
        size--;
        return removed;
    }


    @Override
    public boolean insert(E value) {
        first = new Deque.Node<>(value, first, null);
        last = first;
        size++;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }

        Deque.Node<E> removedNode = first;
        first = removedNode.next;
        removedNode.next = null;
        size--;

        return removedNode.value;
    }

    @Override
    public E peekFront() {
        return first.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        Node<E> current = first;

        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        return sb.append("]").toString();

    }

    private Node<E> indexOf(E value) {
        Node<E> current = first;

        while (current != null) {
            if (current.value.equals(value)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<E> {
        Integer counter;
        Node<E> result;
        public DequeIterator() {
            this.counter = 0;
            result = new Node<E>( null, (Node<E>) null, (Node<E>) last) ;
        }

        @Override
        public boolean hasNext() {
            return size > counter;
        }

        @Override
        public E next() {
            this.counter++;
            result = result.last;
            return result.value;
        }
    }
}
