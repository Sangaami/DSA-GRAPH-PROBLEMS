import java.util.*;
class Graph {
    static class Pair {
        char vertex, des;
        int weight;
        Pair(char vertex, char des, int weight) {
            this.vertex = vertex;
            this.des = des;
            this.weight = weight;
        }
    }
    static int charToIndex(char ch) {
        return ch - 'A';
    }
    static void prims(List<List<Pair>> adj, char start, int cityCount) {
        boolean[] visited = new boolean[cityCount];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        pq.offer(new Pair(start, '-', 0));
        int sum = 0;
        System.out.println("Edges in MST:");
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int idx = charToIndex(curr.vertex);
            if (visited[idx]) continue;
            visited[idx] = true;
            if (curr.des != '-') {
                System.out.println(curr.des + " -> " + curr.vertex + " = " + curr.weight);
                sum += curr.weight;
            }
            for (Pair neighbor : adj.get(idx)) {
                if (!visited[charToIndex(neighbor.vertex)]) {
                    pq.offer(new Pair(neighbor.vertex, curr.vertex, neighbor.weight));
                }
            }
        }
        System.out.println("Total Minimum Cost of MST: " + sum);
    }
}
public class main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("CITIES:");
        String s = sc.next();
        char[] cities = s.toCharArray();
        int V = cities.length;
        List<List<Graph.Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int t=sc.nextInt();
        for (int i = 0; i <t ; i++) {
            char src = sc.next().charAt(0);
            char dest = sc.next().charAt(0);
            int cost = sc.nextInt();
            int srcIdx = src - 'A';
            int destIdx = dest - 'A';
            adj.get(srcIdx).add(new Graph.Pair(dest, src, cost));
            adj.get(destIdx).add(new Graph.Pair(src, dest, cost));
        }
        Graph.prims(adj, cities[0], V);
        sc.close();
    }
}
