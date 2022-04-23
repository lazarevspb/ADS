package ru.lazarev.lesson7.graph.impl;

import ru.lazarev.lesson7.graph.Graph;
import ru.lazarev.lesson7.graph.Vertex;

import java.util.ArrayList;
import java.util.Stack;

public class GraphImpl implements Graph {
    private final ArrayList<Vertex> vertexList;
    private final int[][] adjMatrix;
    private final boolean[][] visitedMatrix;

    int tempDistance = 0;
    public static int distance;
    public static ArrayList<Integer> arrDistance = new ArrayList<>();

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
        this.visitedMatrix = new boolean[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, int distance) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }
        adjMatrix[startIndex][endIndex] = distance;
        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] > 0) {
                    sb.append(" -> ").append(vertexList.get(j));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public void dfs(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Wrong vertex" + startLabel);
        }
        Stack<Vertex> stack = new Stack<>();
        Vertex startVertex = vertexList.get(startIndex);
        Vertex endVertex = vertexList.get(endIndex);
        visitVertex(stack, startVertex);

        while (!stack.isEmpty()) {
            saveDistance(stack.peek(), endVertex);

            if (endVertex.isVisited()) {
                assert startVertex != null;
                startVertex.setVisited(false);
                dfs(startLabel, endLabel);
                break;
            }
            startVertex = getNearUnvisitedVertex(stack.peek());
            if (startVertex == null) {
                stack.pop();
            } else {
                endVertex.setVisited(false);
                visitVertex(stack, startVertex);
            }
        }
    }

    private void saveDistance(Vertex startVertex, Vertex endVertex) {
        int currentIndex = vertexList.indexOf(startVertex);
        int endIndex = vertexList.indexOf(endVertex);

        for (int i = 0; i < getSize(); i++) {

            if (!visitedMatrix[currentIndex][i]) {
                tempDistance += adjMatrix[currentIndex][i];
            }
            if (endVertex.isVisited()) {
                distance = tempDistance;
                tempDistance = 0;
                arrDistance.add(distance);
                return;
            }
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);

        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] > 0 && !visitedMatrix[currentIndex][i]) {
                visitedMatrix[currentIndex][i] = true;
                System.out.print(adjMatrix[currentIndex][i] + "-");
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex startVertex) {
        System.out.println(startVertex.getLabel() + " ");
        stack.push(startVertex);
        startVertex.setVisited(true);
    }
}
