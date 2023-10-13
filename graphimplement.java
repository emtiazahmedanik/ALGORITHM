import java.util.LinkedList;
import java.util.Scanner;

public class graphimplement {

    private LinkedList<Integer> adj [];
    graphimplement(int v){
        adj = new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i]= new LinkedList<>();
        }
    }
    public void insertedge(int s,int d){
        adj[s].add(d);
        adj[d].add(s);
        
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter vertex & edge :");
        int v = input.nextInt();
        int e = input.nextInt();
        graphimplement g = new graphimplement(v);
        System.out.println("Enter edges: ");
        for(int i=0;i<e;i++){
            int s=input.nextInt();
            int d = input.nextInt();
            g.insertedge(s,d);
        }

    }
}
