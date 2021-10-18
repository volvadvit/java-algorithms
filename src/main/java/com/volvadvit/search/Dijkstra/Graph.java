package com.volvadvit.search.Dijkstra;

import java.util.HashMap;
import java.util.Map;

public class Graph {

    private final Node start;
    private final Node end;

    private final Map<Node, Double> nodeToLowestCost = new HashMap<>();

    Graph(Node start, Node end) {
        this.start = start;
        this.end = end;

        nodeToLowestCost.put(start, 0.0);
    }

    // Build graph
    void connectParentToChildren(Node parent, Node child, double value) {
        parent.children.put(child, value);
        nodeToLowestCost.put(child, Double.POSITIVE_INFINITY);
    }

    void findLowestCostWay(Node root) {
        root.children.forEach((child, cost) -> {
            Double currentCost = nodeToLowestCost.get(child);
            Double childCost = nodeToLowestCost.get(root) + cost;
            if (currentCost > childCost) {
                nodeToLowestCost.put(child, childCost);
            }
            findLowestCostWay(child);
        });
    }

    public void showResult() {
        String result = String.format("Dijkstra search, from: %s to: %s, cost: %s", start, end, nodeToLowestCost.get(end));
        System.err.println(result);
    }
}
