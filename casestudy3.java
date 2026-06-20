import java.util.*;

public class BFSDFS {

    private int V;
    private LinkedList<Integer>[] adj;

    BFSDFS(int v) {
        V = v;
        adj = new LinkedList[v];

        for(int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int s) {
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while(!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s + " ");

            for(int n : adj[s]) {
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {

        BFSDFS g = new BFSDFS(5);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(2,3);
        g.addEdge(3,4);

        System.out.println("BFS Traversal:");
        g.BFS(0);
    }
}
