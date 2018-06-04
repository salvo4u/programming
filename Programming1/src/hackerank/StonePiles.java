package hackerank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

public class StonePiles {
	public static HashMap<Integer, ArrayList<ArrayList<Integer>>> hmap = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
	public static String[] winners = { "ALICE", "BOB" };
	
	public static void partition(int n, int max, String temp,
			ArrayList<ArrayList<Integer>> master, ArrayList<Integer> holder) {
		if (n == 0) {
			ArrayList<Integer> temp1 = new ArrayList<Integer>();
			for (int i = 0; i < holder.size(); i++) {
				temp1.add(holder.get(i));
			}
			master.add(temp1);
		}

		for (int i = Math.min(max, n); i >= 1; i--) {
			if (!holder.contains((Integer) i)) {
				holder.add(i);
				partition(n - i, i, temp + " " + i, master, holder);
				holder.remove(holder.size() - 1);
			}
		}
	}

	public static int decideWinner(Set<Integer> currset, int player) {
		int otherplayer = (player == 1) ? 0 : 1;

		if (currset.size() == 1 && (currset.contains((Integer) 1)|| currset.contains((Integer) 2)))
			return otherplayer;
	
		if (currset.size() == 2 && currset.contains((Integer) 1)		&& currset.contains((Integer) 2))
			return otherplayer;

		if (currset.size() == 3 && currset.contains((Integer) 1)	&& currset.contains((Integer) 2)&& currset.contains((Integer) 3))
			return player;

		
		int count = 0;
		for (Iterator<Integer> iterator = currset.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			
			if (integer.equals(1) || integer.equals(2))
				continue;
			
			ArrayList<ArrayList<Integer>> listoflist = hmap.get(integer);
			currset.remove(integer);
			// copy of the original set
			HashSet<Integer> clonedcurrset = new HashSet<Integer>();
			
			for (int j = 0; j < listoflist.size(); j++) {
				ArrayList<Integer> list = listoflist.get(j);
				// add the list
				for (int k = 0; k < list.size(); k++) {
					Integer ele = list.get(k);
					if (!currset.contains(ele)){
						currset.add(ele);
						clonedcurrset.add(ele);
					}
				}
				// call recursion
				int winner = decideWinner(currset, otherplayer);
				if (winner == player)
					count++;
				// remove the list
				for (Iterator iterator2 = clonedcurrset.iterator(); iterator2.hasNext();) {
					Integer integer2 = (Integer) iterator2.next();
					currset.remove(integer2);
				}
			}
			currset.add(integer);
		}

		if (count == 0)
			return otherplayer;
		else
			return player;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String arr[] = s.split(" ");
		int MAX = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			int n = new Integer(arr[i]);
			set.add(n);

			if (MAX < n)
				MAX = n;
		}
		
		for (int n = 3; n <= MAX; n++) {
			ArrayList<ArrayList<Integer>> master = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> holder = new ArrayList<Integer>();
			partition(n, n, "", master, holder);
			master.remove(0);
			hmap.put((Integer) n, master);
		}
		
		int winner = decideWinner(set, 0);
		System.out.println(winners[winner]);
	}
}
