package ru.lazarev.lesson5.backpackProblem;

public class Item {
    private int weight;
    private int value;

    public Item(int weight, int value){
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return value;
    }

    @Override
    public String toString() {
        return "Item{" +
                "weight=" + weight +
                ", value=" + value +
                '}';
    }
}
