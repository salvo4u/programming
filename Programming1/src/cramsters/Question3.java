package cramsters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question3 {
	public static int countCharacters(char array[], int n, char ch) {
		if (n == 0)
			return 0;
		/*if character matches add 1 to the total and 
		call the function again for the next character*/
		if (array[n - 1] == ch)  
			return 1 + countCharacters(array, n - 1, ch);
		/*if character does not match
		call the function again for the next character*/
		return countCharacters(array, n - 1, ch);
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("INPUT a string of characters:");
		String str = br.readLine();
		char array[] = str.toCharArray();
		System.out.println("INPUT a  character:");
		char ch = br.readLine().charAt(0);
		System.out.println("Frequency of " + ch + " in " + str + " is : "
				+ countCharacters(array, array.length, ch));
		br.close();
	}
}
