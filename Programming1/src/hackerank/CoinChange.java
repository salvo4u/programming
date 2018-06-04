package hackerank;
//https://www.hackerrank.com/challenges/ctci-coin-change/problem
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class CoinChange {
	public static int methodCoinChange(HashSet<Integer> set,int money){
		int count = 0;
		if(set.contains(money))
			return 1;
		Iterator<Integer> iter = set.iterator();
		while (iter.hasNext()) {
			Integer m = iter.next();
			if(m>money)
				break;
			count = count + methodCoinChange(set,m) + methodCoinChange(set,money - m);
		}
		return count;
	}
	
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] coins = new int[m];

        String[] coinsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < m; i++) {
            int coinsItem = Integer.parseInt(coinsItems[i]);
            coins[i] = coinsItem;
            set.add(coins[i]);
        }
        System.out.println(methodCoinChange(set,n));
        scanner.close();
    }
}
