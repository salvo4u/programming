package hackerank;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    static HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
    
    public static int Ways(int n){
        int ways = 0;
        if(hmap.get(n)!=null)
            return hmap.get(n);
        ways = (Ways(n-1) + Ways(n-2) + Ways(n-3));  
        
        hmap.put(n,ways);
        return ways;
    }
    public static void main(String[] args) {
        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        hmap.put(1,1);
        hmap.put(2,2);
        hmap.put(3,4);
        
        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            System.out.println(Ways(n));
        }
        
        scanner.close();
    }
}