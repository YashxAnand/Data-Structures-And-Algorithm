import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.*;

//Undirected Graph
public class Graph {
    static Scanner sc = new Scanner(System.in);
    LinkedList<Integer>[] adjacencyList;
    int[] visited;
    Queue<Integer> toExplore;
    Stack<Integer> toExploreStack;
    int n;

    public Graph(int n, int e) {
        adjacencyList = new LinkedList[n];
        visited = new int[n];
        toExplore = new LinkedList<Integer>();
        toExploreStack = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < e; i++) {
            // Taking starting and end point of the edge as input
            int from = sc.nextInt();
            int to = sc.nextInt();
            adjacencyList[from].addLast(to);
            adjacencyList[to].addLast(from);
        }
    }

    public void BFS(int start) {
        visited[start] = 1;
        toExplore.add(start);

        while (toExplore.size() != 0) {
            int element = toExplore.remove().intValue();
            System.out.print((element) + " ");
            adjacencyList[element].forEach(node -> {
                if (visited[node.intValue()] == 0) {
                    visited[node.intValue()] = 1;
                    toExplore.add(node);
                }
            });
        }
        visited = new int[visited.length];
    }

    public void DFS(int start) {
        visited[start] = 1;
        System.out.print(start + " ");
        toExploreStack.add(start);

        adjacencyList[start].forEach(node -> {
            if (visited[node.intValue()] == 0) {
                DFS(node.intValue());
            }
        });
        toExploreStack.pop();
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7, 9); // first argment is number of vertices and 2nd is number of edges
        graph.BFS(6);
    }
}