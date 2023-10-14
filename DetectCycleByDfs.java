import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class DetectCycleByDfs {
    static int curr, par;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter vertex & edge:");
        int v = input.nextInt();
        int e = input.nextInt();
        graphcreate g = new graphcreate(v);
        System.out.println("Enter edges:");
        for (int i = 0; i < e; i++) {
            int s = input.nextInt();
            int d = input.nextInt();
            g.insertedge(s, d);
        }
        System.out.println("Insert source:");
        int source = input.nextInt();
        g.Dfs(source);
        boolean f = g.Cycle(source);
        System.out.println("Has Cycle:"+f);

    }

    public static class graphcreate {
        LinkedList<Integer> adj[];

        graphcreate(int v) {
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void insertedge(int s, int d) {
            adj[s].add(d);
            adj[d].add(s);
        }

        public void Dfs(int source) {

            System.out.println("Traversed by DFS: ");
            boolean visited[] = new boolean[adj.length];
            int parent[] = new int[adj.length];
            Stack<Integer> stack = new Stack<>();
            stack.push(source);
            parent[source] = -1;
            visited[source] = true;
            while (!stack.isEmpty()) {
                int p = stack.pop();
                System.out.println(p + " ");
                par = p;
                for (int i : adj[p]) {
                    curr = i;
                    if (visited[i] != true) {
                        visited[i] = true;
                        stack.push(i);
                        parent[i] = p;
                    }

                }
            }


        }

        public boolean Cycle(int source){
            boolean visited[] = new boolean[adj.length];
            int parent[] = new int[adj.length];
            Stack<Integer> stack = new Stack<>();
            stack.push(source);
            parent[source] = -1;
            visited[source] = true;
            while (!stack.isEmpty()) {
                int p = stack.pop();
                for (int i : adj[p]) {
                    if (visited[i]== true && parent[p]!=i) {
                        return true;
                    }
                    else if (!visited[i]) {
                        visited[i] = true;
                        stack.push(i);
                        parent[i] = p;
                    }

                }
            }
            return false;
        }

    }
}
