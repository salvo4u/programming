package cramsters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question2 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int randomnumber = (int) (Math.random() * 1000);
		while (true) {
			System.out.println("ENTER AN INTEGER BETWEEN 1 and 1000:");
			String s = br.readLine();
			int number = new Integer(s);
			if (number == randomnumber) {
				System.out.println("YOU GOT IT RIGHT :)");
				break;
			}
			if (number < randomnumber)
				System.out.println("!!!! TOO LOW !!!!");
			else
				System.out.println("!!!! TOO HIGH !!!!");
		}
		br.close();
	}
}
	