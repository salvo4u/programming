import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class problem42 {
	public static void main(String args[]) throws IOException {

		// open up standard input
		BufferedReader reader = new BufferedReader(new FileReader(new File(
				"/home/salvo/Desktop/in.txt")));
		String line = null;
		int count=0;
		while ((line = reader.readLine()) != null) {
			int sum = 0;
			System.out.println(line);
			for (int i = 0; i < line.length(); i++)
				sum = sum + (int) line.charAt(i) - 64;
			
			double n=(-1+Math.sqrt(1+8*sum))/2;
			
			if(n-(int)n==0)
				count++;
		}

		// ... Close reader and writer.
		reader.close(); // Close to unlock.
		System.out.println(count);
	}
}