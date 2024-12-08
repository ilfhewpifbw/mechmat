import java.util.*;

public class UndirectedGraph {
    private Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();

    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }

    public void removeVertex(int vertex) {
        adjacencyList.values().forEach(e -> e.remove(vertex));
        adjacencyList.remove(vertex);
    }

    public void addEdge(int vertex1, int vertex2) {
        addVertex(vertex1);
        addVertex(vertex2);
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }

    public void removeEdge(int vertex1, int vertex2) {
        if (adjacencyList.containsKey(vertex1)) {
            adjacencyList.get(vertex1).remove(vertex2);
        }
        if (adjacencyList.containsKey(vertex2)) {
            adjacencyList.get(vertex2).remove(vertex1);
        }
    }

    public void printGraph() {
        for (var entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.printGraph();
        graph.removeEdge(1, 2);
        graph.removeVertex(3);
        graph.printGraph();
    }
}
