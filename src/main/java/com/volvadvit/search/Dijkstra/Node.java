package com.volvadvit.search.Dijkstra;

import java.util.HashMap;
import java.util.Map;

public class Node {

    String name;

    Map<Node, Double> children = new HashMap<>();

    Node(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
