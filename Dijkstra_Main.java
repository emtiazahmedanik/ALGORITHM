package Practice;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra_Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter vertex:");
        int vertex  = input.nextInt();
        System.out.println("Enter edge:");
        int edge = input.nextInt();
        Graph graph = new Graph(vertex);
        for(int i=0;i<edge;i++){
            int s = input.nextInt();
            int d = input.nextInt();
            int w = input.nextInt();
            graph.addedge(s,d,w);
        }
        Dijkastra dij = new Dijkastra(0,vertex, graph.list);
        System.out.println("Dist:");
        int dist []= dij.dist;
        for(int j=0;j<dist.length;j++){
            System.out.println(dist[j]+" ");
        }
    }
    static class Edge{
        int s,d,w;
        Edge(int s,int d,int w){
            this.s=s;
            this.d=d;
            this.w=w;
        }

    }
    static class pair implements Comparable<pair>{
        int node,dist;
        pair(int n,int d){
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(pair p2) {
            return this.dist - p2.dist;
        }
    }
    public static class Graph{
        int v;
        LinkedList<Edge> list[];
        Graph(int v){
            this.v=v;
            list = new LinkedList[v];
            for (int i=0;i<v;i++){
                list[i] = new LinkedList<>();
            }
        }
        public void addedge(int s,int d,int w){
            Edge e = new Edge(s,d,w);
            list[s].add(e);
        }
    }
    public static class Dijkastra{
        int dist[];
        Dijkastra(int source,int v,LinkedList<Edge> list[]){
            PriorityQueue<pair> pq;
            dist= new int[v];
            for(int k=0;k<v;k++){
                if(k!=source)
                    dist[k]=Integer.MAX_VALUE;
            }
            dist[source] = 0;
            boolean[] visited = new boolean[v];
            pq = new PriorityQueue<pair>();
            pq.add(new pair(source,0));

            while (!pq.isEmpty()){
                pair current = pq.poll();
                if(!visited[current.node]){
                    visited[current.node] = true;
                    for(int i=0; i<list[current.node].size();i++){
                        Edge e = list[current.node].get(i);
                        int u = e.s;
                        int wt = e.w;
                        int vd = e.d;
                        if(dist[u]+wt < dist[vd]) {
                            dist[vd] = dist[u] + wt;
                            pq.add(new pair(vd,dist[vd]));
                        }
                    }
                }
            }
        }


    }
}
