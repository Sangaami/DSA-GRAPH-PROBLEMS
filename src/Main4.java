///*You are working as a network administrator for a company. The company has several computers (nodes)
//connected via network cables (edges). The connections are bidirectional, and not all computers are directly
//connected to each other.
//
//Sometimes, when a computer sends a broadcast message, it should reach all other computers in the network
//in the shortest number of hops (i.e., fewest intermediate computers). You are tasked to simulate this broadcast
//operation using Breadth-First Search (BFS).
//
//Your goal is to write a function that:
//
//Traverses the network from a given source computer
//
//Returns the order in which the computers receive the broadcast message
//
//Assumes each edge takes equal time to traverse
//
//Test Case 1 – Small Office Network
//
//Computers: [A, B, C, D]
//
//Connections:
//
//A - B
//A - C
//B - D
//
//Start: A
//
//Expected Output:
//
//Broadcast Order: A, B, C, D
//
//Test Case 2 – Medium Network
//
//Computers: [P, Q, R, S, T, U]
//
//Connections:
//
//P - Q
//P - R
//Q - S
//R - T
//T - U
//
//Start: P
//
//Output :
//
//Broadcast Order: P, Q, R, S, T, U

import java.util.*;

class Graph1 {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    char[] labels;
    Graph1(int v, String labelStr) {
        labels = labelStr.toCharArray();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(char u, char v) {
        int i = index(u);
        int j = index(v);
        if (i != -1 && j != -1) {
            adj.get(i).add(j);
            adj.get(j).add(i);
        } else {
            System.out.println("Invalid node label: " + u + " or " + v);
        }
    }
    int index(char ch) {
        for (int i = 0; i < labels.length; i++) {
            if (labels[i] == ch) return i;
        }
        return -1;
    }
    void bfs(char start) {
        int s = index(start);
        if (s == -1) {
            System.out.println("Invalid starting node!");
            return;
        }

        boolean[] visited = new boolean[labels.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(labels[curr] + " ");

            for (int nei : adj.get(curr)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.add(nei);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("COMPUTER: ");
        String nodes = sc.nextLine().toUpperCase();
        Graph1 g = new Graph1(nodes.length(), nodes);
        System.out.print("Enter number of connections: ");
        int edges = sc.nextInt();
        System.out.println("Enter each connection:");
        for (int i = 0; i < edges; i++) {
            char u = sc.next().toUpperCase().charAt(0);
            char v = sc.next().toUpperCase().charAt(0);
            g.addEdge(u, v);
        }
        System.out.print("Enter starting node for BFS: ");
        char start = sc.next().toUpperCase().charAt(0);
        g.bfs(start);
    }
}
