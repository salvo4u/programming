package hackerank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PermGame {
	public static boolean isSorted(ArrayList<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) > list.get(i + 1))
				return false;
		}
		return true;
	}

	public static String players[] = { "BOB", "ALICE" };

	public static int chooseWinner(ArrayList<Integer> list, int player) {
		int otherplayer = player % 2 == 1 ? 0 : 1;
		if (isSorted(list)) 
			return otherplayer;
		
		int count=0;
		for (int i = 0; i < list.size(); i++) {
			Integer ele = list.get(i);
			list.remove(ele);
			int winner = chooseWinner(list, otherplayer);
			if(winner==player)
				count++;
			list.add(i, ele);
		}
		
		if(count==0)
			return otherplayer;
		else
			return player;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int N = new Integer(s.trim());
		for (int i = 0; i < N; i++) {
			int player = 1;
			s = br.readLine();
			int M = new Integer(s.trim());
			s = br.readLine();
			String arr[] = s.trim().split(" ");
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < arr.length; j++)
				list.add(new Integer(arr[j]));
			String winner = players[chooseWinner(list, player)];
			System.out.println(winner);
		}
		br.close();
	}
}
