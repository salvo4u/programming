import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class problem59 {
	public static void main(String args[]) {
		try {
			FileInputStream fstream = new FileInputStream("textfile.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				System.out.println(strLine);
			}
			in.close();
			String arr[]=strLine.split(",");
				for(int i=0;i<arr.length;i++)
				{
					System.out.println(arr[i].to);
				}
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}
