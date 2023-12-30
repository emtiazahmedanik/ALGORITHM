import java.util.Scanner;

public class ProjectK {
    public static void main(String[] args) {
        ProjectK obj = new ProjectK();
        obj.Front();

        Scanner input = new Scanner(System.in);
        System.out.println("----------------");
        System.out.print("Enter string 1:");
        String str1 = input.next();
        System.out.println("----------------");

        System.out.println("----------------");
        System.out.print("Enter string 2:");
        String str2 = input.next();
        System.out.println("----------------");

        int m = str1.length();
        int n = str2.length();

        final int [][] arr = new int[m+1][n+1];

        for(int i=1; i<=m; i++){

            for(int j=1; j<=n; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    arr[i][j] = arr[i-1][j-1]+1;
                }
                else{
                    arr[i][j] = Math.max(arr[i-1][j],arr[i][j-1]);
                }
            }
            obj.Print(arr,m,n);
            System.out.println("\n");
        }


    }

    public void Front(){
        System.out.println("\t\t----------------------------------------------");
        System.out.println("\t\t\t\t Green University of Bangladesh");
        System.out.println("\t\t\t\t\t Department of CSE");
        System.out.println("\t\t\t\t Name : Md Emtiaz Ahmed");
        System.out.println("\t\t\t\t ID: 221002206");
        System.out.println("\t\t----------------------------------------------");

    }

    public void Print(int arr[][],int m,int n){
        int dp[][]= new int[m+2][n+2];


        for(int i=1;i<=m+1;i++){
            for(int j=0;j<=0;j++){
                dp[i][j]=i-1;
            }
        }
        for(int i=0;i<=0;i++){
            for(int j=1;j<=n+1;j++){
                dp[i][j]=j-1;
            }
        }

        for (int i=2;i<=m+1;i++){
            for(int j=2;j<=n+1;j++){
                dp[i][j]=arr[i-1][j-1];
            }
        }



        for(int i=0;i<=m+1;i++){
            System.out.println();
            for(int j=0;j<=n+1;j++){
                System.out.print(dp[i][j]+" ");
            }
        }

    }
}
