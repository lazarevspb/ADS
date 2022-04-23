package ru.lazarev.lesson7;

import ru.lazarev.lesson7.graph.Graph;
import ru.lazarev.lesson7.graph.impl.GraphImpl;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;

public class App {
    public static final String CITY_1 = "City_1";
    public static final String CITY_2 = "City_2";
    public static final String CITY_3 = "City_3";
    public static final String CITY_4 = "City_4";
    public static final String CITY_5 = "City_5";
    public static final String CITY_6 = "City_6";
    public static final String CITY_7 = "City_7";
    public static final String CITY_8 = "City_8";
    public static final String CITY_9 = "City_9";
    public static final String CITY_17 = "City_17";

    public static void main(String[] args) {

        Graph graph = new GraphImpl(10);

        graph.addVertex(CITY_1);
        graph.addVertex(CITY_2);
        graph.addVertex(CITY_3);
        graph.addVertex(CITY_4);
        graph.addVertex(CITY_5);
        graph.addVertex(CITY_6);
        graph.addVertex(CITY_7);
        graph.addVertex(CITY_8);
        graph.addVertex(CITY_9);
        graph.addVertex(CITY_17);

        graph.addEdge(CITY_1, CITY_2, 90);
        graph.addEdge(CITY_1, CITY_3, 15);
        graph.addEdge(CITY_1, CITY_4, 30);
        graph.addEdge(CITY_2, CITY_5, 100);
        graph.addEdge(CITY_3, CITY_6, 14);
        graph.addEdge(CITY_4, CITY_7, 80);
        graph.addEdge(CITY_5, CITY_17, 20);
        graph.addEdge(CITY_6, CITY_8, 25);
        graph.addEdge(CITY_7, CITY_9, 150);
        graph.addEdge(CITY_8, CITY_17, 15);
        graph.addEdge(CITY_9, CITY_17, 110);


        graph.display();
        graph.dfs(CITY_1, CITY_17);
        ArrayList<Integer> resultList = GraphImpl.arrDistance;

        Integer distance = IntStream.range(0, resultList.size()).boxed()
                .min(comparingInt(resultList::get))
                .orElse(null);

        if (distance != null) {
            System.out.printf("Minimum distance %d%n", resultList.get(distance));
        } else {
            System.out.println("Path not found");
        }

    }
}
