package Practice;

import java.util.LinkedList;
import java.util.Scanner;

public class WeighetGraphImplement_Tecnq2 {
    public static void main(String[] args) {
        System.out.println("Enter vertex and edge:");
        Scanner input = new Scanner(System.in);
        int vertex = input.nextInt();
        int edg = input.nextInt();
        graph g = new graph(vertex);
        System.out.println("Enter source , destination and distance:");
        for(int i=0;i<edg;i++){
            int s,d,w;
            s = input.nextInt();
            d = input.nextInt();
            w = input.nextInt();
            g.addEdge(s,d,w);
        }
        g.print(vertex);

    }
    public static class graph{
        LinkedList<Edge> list [];
        graph(int v){
            list = new LinkedList[v];
            for(int i=0;i<v;i++){
                list[i]=new LinkedList<>();
            }
        }
        void addEdge(int s,int d,int w){
            Edge edge = new Edge(s,d,w);
            list[s].add(edge);
        }
        void print(int v){
            for(int i=0;i<v;i++){
                System.out.println(i+":");
                LinkedList<Edge> list2 = list[i];
                for(int j = 0; j< list2.size(); j++){
                    System.out.println("["+list2.get(j).d+","+list2.get(j).w+"]");
                }
            }
        }


    }
    static class Edge{
        int s;
        int d;
        int w;
        Edge(int s,int d,int w){
            this.s = s;
            this.d = d;
            this.w = w;
        }
    }
}

