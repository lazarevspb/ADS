package ru.lazarev.lesson4;

import ru.lazarev.lesson4.deque.impl.LinkedDequeImpl;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        testLinkedList();
        testIterator();
    }

    private static void testLinkedList() {
        var linkedList = new LinkedDequeImpl<>();

        linkedList.display();
        linkedList.insert(0);
        linkedList.display();
        linkedList.insertRight(1);
        linkedList.insertRight(2);
        linkedList.insertLeft(-1);
        linkedList.insertLeft(-2);
        linkedList.display();
        linkedList.removeRight();
        linkedList.display();
        linkedList.removeLeft();
        linkedList.display();
        testHomeWork(linkedList);
    }

    private static void testHomeWork(LinkedDequeImpl linkedList) {
        for (Object value : linkedList) {
            System.out.println("value: " + value);
        }
    }

    private static void testIterator() {
        List<Integer> linkedList = new java.util.LinkedList<>();
        Collections.addAll(linkedList, 1, 2, 3, 4, 5, 6, 7, 8, 9);

/*        for (Integer integer : linkedList) {
            System.out.println(integer);
        }*/

        ListIterator<Integer> iterator = linkedList.listIterator();
        //first:reset
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println(integer + " до него " + iterator.previous());
            iterator.next();
            if (!iterator.hasNext()) {
                break;
            }
        }
    }
}
