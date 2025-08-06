import java.util.*;

public class main7 {
    static class Edge {
        int u, v, wt;
        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    static int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    static void union(int[] parent, int[] rank, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);
        if (px == py) return;

        if (rank[px] < rank[py]) parent[px] = py;
        else if (rank[px] > rank[py]) parent[py] = px;
        else {
            parent[py] = px;
            rank[px]++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.wt));
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt(), v1 = sc.nextInt(), w = sc.nextInt();
            pq.offer(new Edge(u, v1, w));
        }

        int[] parent = new int[v];
        int[] rank = new int[v];
        for (int i = 0; i < v; i++) parent[i] = i;

        int cost = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int pu = find(parent, edge.u);
            int pv = find(parent, edge.v);

            if (pu != pv) {
                union(parent, rank, pu, pv);
                System.out.println(edge.u + " - " + edge.v + " = " + edge.wt);
                cost += edge.wt;
            }
        }

        System.out.println("Total cost: " + cost);
    }
}

