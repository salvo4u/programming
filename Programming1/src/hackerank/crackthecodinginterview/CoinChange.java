package hackerank.crackthecodinginterview;
//https://www.hackerrank.com/challenges/ctci-coin-change/problem
import java.util.Scanner;

public class CoinChange {
	private static int mat[][];
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nm = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[] coins = new int[m];
        String[] coinsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < m; i++) {
            int coinsItem = Integer.parseInt(coinsItems[i]);
            coins[i] = coinsItem;
        }
        mat = new int[m][n+1];
        for(int i=0;i<m;i++){
        	for(int j=0;j<=n;j++){
        		if(i==0 && j%coins[i]==0){
        			mat[i][j] = 1;
        			continue;
        		}
        		if(j==0){
        			mat[i][j] = 1;
        			continue;
        		}
        		if(j-coins[i]<0 && i-1>=0)
        		{
        			mat[i][j] = mat[i-1][j];
        		}
        		if(i-1>=0 && j-coins[i]>=0)
        			mat[i][j] = mat[i-1][j] + mat[i][j-coins[i]]; 
        	}
        }        
        System.out.println(mat[m-1][n]);
        scanner.close();
    }
}
