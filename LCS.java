import java.util.Scanner;

public class LCS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter string 1:");
        String str1 = input.next();
        System.out.println("Enter string 2:");
        String str2 = input.next();
        System.out.println(" "+str1+ " "+str2);

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
        }

        for(int i=0; i<=m; i++){
            System.out.println();
            for(int j=0; j<=n; j++) {
                System.out.print(arr[i][j]+" ");
            }
        }
            }


    }



