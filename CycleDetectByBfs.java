import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CycleDetectByBfs {

    public static void main(String[] args) {
        System.out.println("Enter  vertex and edges: ");
        Scanner input = new Scanner(System.in);
        int v = input.nextInt();
        int e = input.nextInt();
        graphcreate g = new graphcreate(v);
        System.out.println("Enter Edges:");
        for (int i = 0; i < e; i++) {
            int s = input.nextInt();
            int d = input.nextInt();
            g.insertedge(s,d);
        }
        boolean f=g.Bfs(2);
        System.out.println("Cycle :"+f);


    }
    public static class graphcreate{

        LinkedList<Integer> adj[] ;
        graphcreate(int v){
            adj = new LinkedList[v];
            for(int i=0;i<v;i++){
                adj[i]=new LinkedList<Integer>();
            }
        }

        public void insertedge(int s, int d){
            adj[s].add(d);
            adj[d].add(s);
        }
        public boolean Bfs(int source){
            boolean cycle=false;
            boolean visited[] = new boolean[adj.length];
            int parent[] = new int[adj.length];
            Queue<Integer> q = new LinkedList<>();
            q.add(source);
            visited[source]=true;
            parent[source]= -1;
            while (!q.isEmpty()){
                int p = q.poll();
                for(int i:adj[p]){
                    if(visited[i]==true && parent[p]!=i){
                        return true;
                    }
                    else if(visited[i]!= true) {
                        visited[i] = true;
                        q.add(i);
                        parent[i] = p;
                    }

                }
            }

            return false;
        }
    }
}





