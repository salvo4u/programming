package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class CombinationSum {
	public static HashMap<Integer, ArrayList<Set<Integer>>> finalmap = new HashMap<Integer, ArrayList<Set<Integer>>>();

	public static ArrayList<Set<Integer>> generateLists() {
		ArrayList<Set<Integer>> list = new ArrayList<Set<Integer>>();
		list.add(new TreeSet<Integer>());
		return list;
	}
	public static ArrayList<Set<Integer>> list = new ArrayList<Set<Integer>>();
	
	public static ArrayList<Set<Integer>> allCombinationNumber(int n) {
		if(n==3){
			ArrayList<Set<Integer>> l=new ArrayList<Set<Integer>>();
			Set<Integer> set=new TreeSet<Integer>();
			set.add(1);
			set.add(2);
			l.add(set);
			finalmap.put(n,l);
			return l;
		}
		
		if(finalmap.get(n)!=null)
			return finalmap.get(n);
		
		for (int i = 1; i <= n / 2; i++) {
			System.out.println(n-i);
			list = allCombinationNumber(n - i);
			System.out.println(n-i+" "+list);
			for (int j = 0; j < list.size(); j++) {
				if (!list.get(j).contains(i))
					list.get(j).add(i);
			}
			Set set=new TreeSet<Integer>();
			set.add(i);
			set.add(n-i);
			list.add(set);
		}
		finalmap.put(n,list);
		return list;
	}

	public static void main(String args[]) {
		int num[] = { 1, 2 }, target = 2;
		// int num[] = { 2,3,6,7 }, target = 7;
		// int num[] = { 1,2,3,6,7 }, target = 7;
		// int num[] = {2,3,6,7,12}, target = 30;
		System.out.println(allCombinationNumber(6));
		System.out.println(finalmap);
	}
}
