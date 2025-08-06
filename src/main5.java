import java.util.*;

class Edge {
    char to;
    int weight;
    Edge(char to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Character> nodes = new ArrayList<>();
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();

        System.out.print("Enter nodes: ");
        String str = sc.nextLine();
        for (char c : str.toCharArray()) {
            nodes.add(c);
            adj.add(new ArrayList<>());
        }

        System.out.print("Enter number of edges: ");
        int m = sc.nextInt();

        System.out.println("Enter each edge:");
        for (int i = 0; i < m; i++) {
            char u = sc.next().charAt(0);
            char v = sc.next().charAt(0);
            int w = sc.nextInt();
            int ui = nodes.indexOf(u);
            int vi = nodes.indexOf(v);
            adj.get(ui).add(new Edge(v, w));
            adj.get(vi).add(new Edge(u, w));
        }

        boolean[] vis = new boolean[nodes.size()];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(e -> e.weight));
        char start = nodes.get(0);
        int si = nodes.indexOf(start);
        vis[si] = true;
        pq.addAll(adj.get(si));

        int total = 0;
        System.out.println("\nMST Edges:");

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int idx = nodes.indexOf(cur.to);
            if (!vis[idx]) {
                vis[idx] = true;
                total += cur.weight;
                System.out.println("--> " + nodes.get(si) + " - " + cur.to + " = " + cur.weight);
                pq.addAll(adj.get(idx));
                si = idx;
            }
        }

        System.out.println("Total weight: " + total);
    }
}
