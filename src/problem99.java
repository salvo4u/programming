import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class problem99 {
	public static void main(String args[]) {

		long t1 = System.currentTimeMillis();

		try {
			FileInputStream fstream = new FileInputStream("c:\\input.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			double max = 0;
			int count = 0, mycount = 0;
			while ((strLine = br.readLine()) != null) {
				String arr[] = strLine.split(",");
				Integer a = new Integer(arr[0]);
				Integer b = new Integer(arr[1]);
				double log = b * Math.log10(a);
				count++;
				if (log > max) {
					max = log;
					mycount = count;
				}
			}
			in.close();
			System.out.println(mycount);

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

		long t2 = System.currentTimeMillis();
		System.out.println("TIME: " + (t2 - t1) + " millisec");
	}
}
