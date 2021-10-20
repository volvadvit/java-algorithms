package com.volvadvit.search.Dijkstra;

/**
 * Алгоритм поиска Дейкстры.
 *
 * Время - O(n^2 + m),
 * где  n - кол-во вершин, m - кол-во ребер.
 *
 * В данном примере используется ориентированный граф,
 * и связи в connect - добавляются в одну сторону.
 */
public class Dijkstra {

    public static void main(String[] args) {
/*    start
      /   \
     6     2
     A <-3-- B
     1      5 \
      \    /   2
       end <-1- C
*/
        Node start = new Node("Start");
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node end = new Node("End");

        // If change start & end nodes, directions of connections needs be changed too.
        Graph graph = new Graph(start, end);

        graph.connectParentToChildren(start, a, 6.0);
        graph.connectParentToChildren(start, b, 2.0);
        graph.connectParentToChildren(a, end, 1.0);
        graph.connectParentToChildren(b, a, 3.0);
        graph.connectParentToChildren(b, end, 5.0);
        graph.connectParentToChildren(b, c, 2.0);
        graph.connectParentToChildren(c, end, 1.0);

        graph.findLowestCostWay();
        graph.showResult();
    }
}
