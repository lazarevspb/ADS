package ru.lazarev.lesson5.backpackProblem;

import java.util.ArrayList;
import java.util.List;

public class BackpackProblem {
    private static final double CAPACITY = 100;
    private static List<Item> bestSet;
    private static double bestPrice;


    public static void main(String[] args) {
        final List<Item> items = getItems();
        System.out.println(getBestSet(items));
    }

    private static List<Item> getItems() {
        final List<Item> items = new ArrayList<>();
        items.add(new Item(5, 15));
        items.add(new Item(20, 30));
        items.add(new Item(5, 10));
        items.add(new Item(30, 90));
        items.add(new Item(50, 100));
        return items;
    }

    private static double getWeight(List<Item> items) {
        double result = 0;
        for (Item item : items) {
            result += item.getWeight();
        }
        return result;
    }

    private static double getPrice(List<Item> items) {
        double result = 0;
        for (Item item : items) {
            result += item.getPrice();
        }
        return result;
    }

    private static void selection(List<Item> items) {
        if (bestSet == null) {
            if (getWeight(items) <= CAPACITY) {
                bestSet = items;
                bestPrice = getPrice(items);
            }
        } else {
            if (getWeight(items) <= CAPACITY && getPrice(items) > bestPrice) {
                bestSet = items;
                bestPrice = getPrice(items);
            }
        }
    }

    public static void getPack(List<Item> items) {
        if (items.size() > 0)
            selection(items);

        for (int i = 0; i < items.size(); i++) {
            List<Item> newSet = new ArrayList<>(items);
            newSet.remove(i);
            getPack(newSet);
        }

    }

    public static List<Item> getBestSet(List<Item> items) {
        getPack(items);
        return bestSet;
    }
}

































