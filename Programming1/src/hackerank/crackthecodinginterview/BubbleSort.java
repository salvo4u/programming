package hackerank.crackthecodinginterview;

import java.util.Scanner;


public class BubbleSort {
	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        Heap1 maxheap = new Heap1();
        maxheap.ismaxheap = true;
        Heap1 minheap = new Heap1();
        minheap.ismaxheap = false;
        
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            int aItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            a[i] = aItem;
        }
        int count = 0;
        boolean issorted = true;
        int i=0;
        do{
        	
        	issorted = true;
        	for(int j=i+1;j<n;j++){
        		if(a[i]>a[j]){
        			int temp = a[i];
        			a[i] = a[j];
        			a[j] = temp;
        			count++;
        			issorted = false;
        		}
        	}
        	i++;
        }while(!issorted);
    
        System.out.println("Array is sorted in "+ count+ " swaps.");
        System.out.println("First Element: "+ a[0]);
        System.out.println("Last Element: "+a[n-1]);
        
	}
}
