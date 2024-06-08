import java.util.*;

public class BFS {
    private int V;
    private Map<Character, LinkedList<Character>> adj;

    public BFS(int v) {
        V = v;
        adj = new HashMap<>();
        for (char c = 'A'; c < 'A' + v; c++)
            adj.put(c, new LinkedList<>());
    }

    public void addEdge(char v, char w) {
        adj.get(v).add(w);
    }

    public void DFSUtil(char v, boolean visited[]) {
        visited[v - 'A'] = true;
        System.out.print(v + " ");

        for (char n : adj.get(v)) {
            if (!visited[n - 'A'])
                DFSUtil(n, visited);
        }
    }

    public void BFS(char s) {
        boolean visited[] = new boolean[V];

        DFSUtil(s, visited);
    }

    public static void main(String args[]) {
        BFS g = new BFS(5);
        g.addEdge('B', 'C');
        g.addEdge('B', 'A');
        g.addEdge('C', 'A');
        g.addEdge('A', 'B');
        g.addEdge('A', 'D');
        g.addEdge('D', 'D');

        System.out.println("Following is Depth First Traversal (starting from vertex A)");
        g.BFS('A');
    }
}
