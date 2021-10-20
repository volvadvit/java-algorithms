package com.volvadvit.search.BFS;

import java.util.*;

/**
 * Поиск в ширину.
 *
 * Время - O(V + E), память ~ O(V),
 * где  V - кол-во вершин, E - кол-во ребер.
 */
public class BreadthFirst {

    public static void main(String[] args) {

        Node zero = new Node("John", 0);
        Node one = new Node("Mike", 1);
        Node two = new Node("Frank", 2);
        Node three = new Node("Ross", 3);
        Node four = new Node("Ben", 4);
        Node five = new Node("Alice", 5);

        zero.connect(one);
        zero.connect(two);
        zero.connect(five);
        one.connect(four);
        two.connect(three);
        three.connect(four);

        System.err.println("Node with searched value: " + search(zero, 4));
    }

    private static String search(Node root, int searchedValue) {
        Queue<Node> queue = new ArrayDeque<>();
        Set<Node> alreadySearched = new HashSet<>();
        queue.add(root);

        Node currentNode;

        while(!queue.isEmpty()) {
            currentNode = queue.remove();
            alreadySearched.add(currentNode);

            if (currentNode.value == searchedValue) {
                return currentNode.name;
            } else {
                queue.addAll(currentNode.neighbours);
                queue.removeAll(alreadySearched);
            }
        }
        return null;
    }
}
