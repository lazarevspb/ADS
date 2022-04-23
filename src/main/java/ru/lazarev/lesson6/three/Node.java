package ru.lazarev.lesson6.three;

public class Node<T extends Comparable<T>> {
    private T value;

    private Node<T> leftChild;
    private Node<T> rightChild;
    Boolean isRepeat;
    private int repeatCount;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public boolean isLeftChild(T value) {
        return getValue().compareTo(value) > 0;
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    public boolean hasOnlyOneChild() {
/*        return leftChild == null && rightChild != null
                || rightChild == null && leftChild != null;*/
        return rightChild != null ^ leftChild != null;
    }
}

