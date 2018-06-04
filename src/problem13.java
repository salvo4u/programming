import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class problem13 {
	//to add two numbers using strings a,b are two numbers
	public static String add(String a, String b) {
		String sum = "";
		int carry = 0;
		if (a.length() > b.length()) {
			String temp = a;
			a = b;
			b = temp;
		}
		for (int i = 0; i < a.length(); i++) {
			int s = a.charAt(a.length() - 1 - i) + b.charAt(b.length() - 1 - i)
					- 96 + carry;
			if (s > 9) {
				carry = (s - s % 10) / 10;
				s = s % 10;
			} else {
				carry = 0;
			}
			sum = s + sum;
		}

		for (int i = 0; i < b.length() - a.length(); i++) {
			int s = b.charAt(b.length() - a.length() - 1 - i) + carry - 48;

			if (s > 9) {
				carry = (s - s % 10) / 10;
				s = s % 10;
			} else {
				carry = 0;
			}
			sum = s + sum;

		}
		if (carry != 0)
			return carry + sum;
		else
			return sum;
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String args[]) throws IOException {
			String s=add("111","999");
			List<String> l=new ArrayList();
	

		      //  open up standard input
		      BufferedReader reader = new BufferedReader(new FileReader(new File("/home/salvo/input13")));
		      String line = null,sum="0";
		        while ((line=reader.readLine()) != null){
		        	// Write system dependent end of line.
		        	sum=add(sum,line);
		        	
		        }

		        //... Close reader and writer.
		        reader.close();  // Close to unlock.
			
			System.out.println("\n"+sum);
	}
}
