package Practice;

import java.util.LinkedList;
import java.util.Scanner;

public class Graph {
    public static void main(String[] args) {
        CreateGraph g;
        System.out.println("Enter vertex & edge:");
        int vertex;
        int edge;
        Scanner input = new Scanner(System.in);
        vertex = input.nextInt();
        edge = input.nextInt();
        g =new CreateGraph(vertex);
        for(int i=0; i<edge ; i++){
            System.out.println("Enter source , destination & weight:");
            int s,d,w;
            s = input.nextInt();
            d = input.nextInt();
            w = input.nextInt();

            g.insertedge(s,d,w);
        }
        g.printing();
    }
    public static class CreateGraph{
        int V;
        LinkedList<LinkedList<Integer>> li[] ;
        CreateGraph(int V) {
            this.V = V;
            li = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                li[i] = new LinkedList<>();
            }
            
        }
        void insertedge(int s,int d,int w){
            LinkedList<Integer> link2 = new LinkedList<>();
            link2.add(d);
            link2.add(w);
            li[s].add(link2);
        }
        void printing(){
            for(int i=0; i<V;i++){
                System.out.println(i+":");
                LinkedList<LinkedList<Integer>> li2 = li[i];
                for(int j=0;j<li2.size();j++){
                    LinkedList<Integer> li3 = li2.get(j);
                    System.out.println("Des:"+li3.get(0)+"Weight:"+li3.get(1));
                }
            }
        }

    }

}
