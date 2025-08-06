import java.util.*;

class Dijkstra {
    static class Pair {
        int vertex, weight;

        Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void dijkstra(int V, List<List<Pair>> adj, int source) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        pq.add(new Pair(source, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.vertex;

            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.vertex;
                int w = neighbor.weight;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        // Print shortest distances from source
        System.out.println("Vertex\tDistance from Source " + source);
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // Adding edges (undirected graph, so add both ways)
        adj.get(0).add(new Pair(1, 10));
        adj.get(0).add(new Pair(4, 5));
        adj.get(1).add(new Pair(2, 1));
        adj.get(1).add(new Pair(4, 2));
        adj.get(2).add(new Pair(3, 4));
        adj.get(3).add(new Pair(0, 7));
        adj.get(3).add(new Pair(2, 6));
        adj.get(4).add(new Pair(1, 3));
        adj.get(4).add(new Pair(2, 9));
        adj.get(4).add(new Pair(3, 2));

        int source = 0;
        dijkstra(V, adj, source);
    }
}
//steps 1: Create a list
