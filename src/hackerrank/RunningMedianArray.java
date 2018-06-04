//https://www.hackerrank.com/challenges/ctci-find-the-running-median/problem
import java.util.ArrayList;
import java.util.Scanner;
//children at indices 2i + 1 and 2i + 2
//its parent at index floor((i − 1) ∕ 2)
class Heap1{
	HeapNode head;
	int count = 0;
	ArrayList<HeapNode> heap =  new ArrayList<HeapNode>();
	boolean ismaxheap = true;
	void insert(int elem){
		HeapNode n =  new HeapNode();
		n.index = count;
		n.leftindex = 2*count + 1;
		n.rightindex = 2*count + 2;
		n.element = elem;
		heap.add(n.index,n);
		count++;
		heapify(0);
	}
	void heapify(int index){
		HeapNode n = heap.get(index),left = null,right = null;
		if(n.leftindex < heap.size())
			left = heap.get(n.leftindex);
		if(n.rightindex < heap.size())
			right = heap.get(n.rightindex);
		HeapNode swapnode = n;
		if(ismaxheap){
			if(left!=null && left.index<=count && left.element > n.element){
				swapnode = left;
			}
			if(right!=null && right.index<=count && right.element > n.element){
				swapnode = right;
			}
		}else{
			if(left!=null && left.index<=count && left.element < n.element){
				swapnode = left;
			}
			if(right!=null && right.index<=count && right.element < n.element){
				swapnode = right;
			}
		}
		
		if(swapnode != n){
			int temp = n.element;
			n.element = swapnode.element;
			swapnode.element = temp;
			heapify(swapnode.index);
		}
	}
	
	void remove(int index){
		HeapNode swapnode = heap.get(count-1);
		HeapNode n = heap.get(index);
		int temp = n.element;
		n.element = swapnode.element;
		swapnode.element = temp;
		heap.remove(count-1);
		count--;
		heapify(0);
	}
}

class HeapNode{
	int element;
	int index;
	int leftindex; 
	int rightindex;
}

public class RunningMedianArray {
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
            maxheap.insert(a[i]);
        }
        scanner.close();
    }
}
