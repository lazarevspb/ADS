package ru.lazarev.lesson7.graph;

public interface Graph {

    void addVertex(String label);

    @SuppressWarnings("UnusedReturnValue")
    boolean addEdge(String startLabel, String secondLabel, int distance);

    int getSize();

    void display();

    void dfs(String startLabel, String endLabel);
}
