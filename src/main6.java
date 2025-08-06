import java.util.*;

public class main6 {
    static class Edge {
        int to, wt;
        Edge(int to, int wt) {
            this.to = to;
            this.wt = wt;
        }
    }

    static class Pair {
        int from, to, wt;
        Pair(int from, int to, int wt) {
            this.from = from;
            this.to = to;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<Edge>[] g = new ArrayList[v];
        for (int i = 0; i < v; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt(), v1 = sc.nextInt(), w = sc.nextInt();
            g[u].add(new Edge(v1, w));
            g[v1].add(new Edge(u, w));
        }

        boolean[] vis = new boolean[v];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.wt));

        vis[0] = true;
        for (Edge edge : g[0]) {
            pq.offer(new Pair(0, edge.to, edge.wt));
        }

        int total = 0;
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (vis[cur.to]) continue;
            vis[cur.to] = true;
            System.out.println(cur.from + " - " + cur.to + " = " + cur.wt);
            total += cur.wt;

            for (Edge edge : g[cur.to]) {
                if (!vis[edge.to])
                    pq.offer(new Pair(cur.to, edge.to, edge.wt));
            }
        }

        System.out.println("Total cost: " + total);
    }
}
