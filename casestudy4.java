import java.util.*;

public class Dijkstra {

    static final int V = 5;

    int minDistance(int dist[], boolean visited[]) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    void dijkstra(int graph[][], int src) {
        int dist[] = new int[V];
        boolean visited[] = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {

            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] &&
                        graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("Shortest distances:");
        for(int i=0;i<V;i++)
            System.out.println(i + " -> " + dist[i]);
    }

    public static void main(String[] args) {

        int graph[][] = {
                {0,4,2,0,0},
                {4,0,1,5,0},
                {2,1,0,8,10},
                {0,5,8,0,2},
                {0,0,10,2,0}
        };

        new Dijkstra().dijkstra(graph,0);
    }
}
