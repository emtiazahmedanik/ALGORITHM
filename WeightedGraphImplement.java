import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WeightedGraphImplement {
    public static void main(String[] args) {
        System.out.println("Enter  vertex and edges and weight: ");
        Scanner input = new Scanner(System.in);
        int v = input.nextInt();
        int e = input.nextInt();

        graphcreateOfWeight g = new graphcreateOfWeight(v);
        System.out.println("Enter Edges and weight:");
        for (int i = 0; i < e; i++) {
            int s = input.nextInt();
            int d = input.nextInt();
            int w = input.nextInt();
            g.insertedge(s,d,w);

        }
        g.printing();
    }
    public static class graphcreateOfWeight{

       LinkedList<LinkedList<Integer>> adj[] ;
       int V;
        graphcreateOfWeight(int v){
            V=v;
            adj = new LinkedList[v+1];
            for(int i=0;i<=v;i++){
                adj[i]=new LinkedList<LinkedList<Integer>>();
            }
        }

        public void insertedge(int s, int d, int w){
            LinkedList<Integer>l1 = new LinkedList<>();
            l1.add(d);
            l1.add(w);
            adj[s].add(l1);
            LinkedList<Integer>l2 = new LinkedList<>();
            l2.add(s);
            l2.add(w);
            adj[d].add(l2);

        }
        void printing(){
            for(int i=1; i<=V;i++){
                System.out.println(i+":");
                for(LinkedList<Integer> j:adj[i]){
                    System.out.println(j);
                }
            }
        }


    }

}
