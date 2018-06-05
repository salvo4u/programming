package hackerank.crackthecodinginterview;
//https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HashTables {

    // Complete the solve function below.
    static void solve(int[] arr, Integer money) {
        HashMap<Integer, String> map = new HashMap<Integer,String>();
        for(int i=0;i<arr.length;i++){
            if(map.get(arr[i])==null)
                map.put(arr[i],"");
            map.put(arr[i],map.get(arr[i]) + " " + (i+1));
        }
        
        for (Integer entry : map.keySet()) {
            int remainder = money - entry;
            String s1 = map.get(entry);
            String s2 = map.get(remainder);
            if(s2!=null)
            {
                if(remainder == entry){
                    String arr1[]= s2.split(" ");
                    Integer x1 = new Integer(arr1[1]);
                    Integer x2 = new Integer(arr1[2]);
                    System.out.println(x1.compareTo(x2)<1?(x1 + " " + x2):(x2 + " " + x1));
                    return;
                }
                Integer x1 = new Integer(s1.trim());
                Integer x2 = new Integer(s2.trim());
                System.out.println(x1.compareTo(x2)<1?(x1 + " " + x2):(x2 + " " + x1));
                return;
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            	
            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
             
            }
            solve(arr, money);
        }

        scanner.close();
    }
}
