import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class PrimAlgorithm {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        System.out.println("Enter edges (source destination weight):");
        for (int i = 0; i < E; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            int weight = scanner.nextInt();
            addEdge(graph, src, dest, weight);
        }

        scanner.close();

        primMST(graph, V);
    }



        static class Edge {
            int destination;
            int weight;

            public Edge(int destination, int weight) {
                this.destination = destination;
                this.weight = weight;
            }
        }

        static class Node implements Comparable<Node> {
            int vertex;
            int key;

            public Node(int vertex, int key) {
                this.vertex = vertex;
                this.key = key;
            }

            @Override
            public int compareTo(Node other) {
                return Integer.compare(this.key, other.key);
            }
        }

        public static void primMST(ArrayList<ArrayList<Edge>> graph, int V) {
            boolean[] visited = new boolean[V];
            int[] parent = new int[V];
            int[] key = new int[V];

            for (int i = 0; i < V; i++) {
                key[i] = Integer.MAX_VALUE;
            }

            PriorityQueue<Node> minHeap = new PriorityQueue<>();

            key[0] = 0; // Starting from the first vertex
            minHeap.add(new Node(0, 0));

            while (!minHeap.isEmpty()) {
                int u = minHeap.poll().vertex;
                visited[u] = true;

                for (Edge neighbor : graph.get(u)) {
                    int v = neighbor.destination;
                    int weight = neighbor.weight;

                    if (!visited[v] && weight < key[v]) {
                        parent[v] = u;
                        key[v] = weight;
                        minHeap.add(new Node(v, key[v]));
                    }
                }
            }


            System.out.println("Edges in the Minimum Spanning Tree:");
            for (int i = 1; i < V; i++) {
                System.out.println("Edge: " + parent[i] + " - " + i + " Weight: " + key[i]);
            }
        }


        static void addEdge(ArrayList<ArrayList<Edge>> graph, int src, int dest, int weight) {
            graph.get(src).add(new Edge(dest, weight));
            graph.get(dest).add(new Edge(src, weight));
        }
    }


