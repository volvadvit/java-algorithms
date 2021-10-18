package com.volvadvit.search.BFS;

import java.util.HashSet;
import java.util.Set;

public class Node {

    String name;
    int value;
    Set<Node> neighbours;

    public Node(String name, int value) {
        this.name = name;
        this.value = value;
        this.neighbours = new HashSet<>();
    }

    void connect(Node neighbor) {
        this.neighbours.add(neighbor);
    }
}
