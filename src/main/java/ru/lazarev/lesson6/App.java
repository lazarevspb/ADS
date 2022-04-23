package ru.lazarev.lesson6;

import ru.lazarev.lesson6.three.Tree;
import ru.lazarev.lesson6.three.impl.TreeImpl;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        int arrLength = 20;

        Stream.iterate(0, n -> n += 1)
                .limit(arrLength)
                .peek(System.out::println)
                .map(App::getRandomTree)
                .peek(Tree::display)
                .peek(App::isBalancedPrint)
                .collect(Collectors.toList())
                .toArray(new Tree[arrLength]);
    }

    private static Tree<Integer> getRandomTree(Integer integer) {
        Tree<Integer> resultTree = new TreeImpl<>();
        new Random().ints(25, -25, +26).forEach(resultTree::add);
        return resultTree;
    }

    private static void isBalancedPrint(Tree<Integer> integerTree) {
        System.out.println("Tree " + (integerTree.isBalanced() ? "balance" : "not balanced"));
    }
}
