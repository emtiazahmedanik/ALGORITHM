import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSTraversal {

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
        g.Bfs(2);


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
        public void Bfs(int source){
            boolean visited[] = new boolean[adj.length];
            int parent[] = new int[adj.length];
            Queue<Integer> q = new LinkedList<>();
            q.add(source);
            visited[source]=true;
            parent[source]= -1;
            while (!q.isEmpty()){
                int p = q.poll();
                System.out.println(p+" ");

                    for(int i:adj[p]){
                        if(visited[i]!= true){
                            visited[i] = true;
                            q.add(i);
                            parent[i]=p;
                    }

                    }
                }
            }
        }
    }





