package random;

import java.util.Arrays;
import java.util.Comparator;

class MyObject implements Comparable<MyObject> {
	String name;
	int roll;

	@Override
	public int compareTo(MyObject o) {
		return name.compareTo(o.name);
	}

	public MyObject(String s, int r) {
		this.name = s;
		this.roll = r;
	}
}

class RollComparoator implements Comparator<MyObject> {

	@Override
	public int compare(MyObject o1, MyObject o2) {
		return o1.roll - o2.roll;
	}

}

public class MyComparator {
	public static void main(String[] args) {
		MyObject arr[] = new MyObject[5];
		arr[0] = new MyObject("Anshul", 1);
		arr[1] = new MyObject("Varun", 2);
		arr[2] = new MyObject("Tarun", 5);
		arr[3] = new MyObject("Ankit", 3);
		arr[4] = new MyObject("Mohit", 4);
		Arrays.sort(arr);
		for (int i = 0; i < 5; i++) {
			System.out.println(arr[i].name + "  " + arr[i].roll);
		}
		
		Arrays.sort(arr,new RollComparoator());
		for (int i = 0; i < 5; i++) {
			System.out.println(arr[i].name + "  " + arr[i].roll);
		}
	}
}
