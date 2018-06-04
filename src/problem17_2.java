import java.io.*;

public class problem17_2 {
	public static void main(String args[]) {
		try {
			
			FileInputStream fstream = new FileInputStream("C:\\Users\\TEMP\\Desktop\\output.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int count=0;
			while ((strLine = br.readLine()) != null) {
				for(int i=0;i<strLine.length();i++)
				{
					
					if(strLine.charAt(i)!=' ')
						count++;
						
				}
				System.out.println(strLine);
			}
			System.out.println(count);
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}

	}
}
