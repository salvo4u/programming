package hackerank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pblm1 {


	public static void printM(int M[][], int N) {
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(M[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void rotateM(int M[][], int N, int l, int dir) {
		if (dir == 0) {
			int temp = M[l-1][l-1];
			int lasttemp =0;
			for (int i = l - 1; i <= N - l-1; i++) {
				if (i == N - l)
					break;
				lasttemp = M[l-1][i+1];
				M[l-1][i+1] = temp;
				temp = lasttemp;
			}
			temp=lasttemp;
			for (int i = l - 1 ; i <= N - l-1; i++) {
				if (i == N - l)
					break;
				lasttemp = M[i+1][N-l];
				M[i+1][N-l] = temp;
				temp = lasttemp;
			}
			temp=lasttemp;
			for (int i = N - l; i >=1; i--) {
				if (i == 0)
					break;
				lasttemp = M[N-l][i-1];
				M[N-l][i-1] = temp;
				temp = lasttemp;
			}
			temp = lasttemp;
			for (int i = N - l ; i >= l-1; i--) {
				if (i == l-1)
					break;
				lasttemp = M[i-1][l-1];
				M[i-1][l-1] = temp;
				temp = lasttemp;
			}
		}
		else
		{
			int temp = M[l-1][l-1];
			int lasttemp =0;
			for (int i = l - 1; i <= N - l - 1; i++) {
				if (i == N - l)
					break;
				lasttemp = M[i+1][l-1];
				M[i+1][l-1] = temp;
				temp = lasttemp;
			}
			temp=lasttemp;
			for (int i = l - 1; i <= N - l; i++) {
				if (i == N - l)
					break;
				lasttemp = M[N-l][i+1];
				M[N-l][i+1] = temp;
				temp = lasttemp;
			}
			temp=lasttemp;
			for (int i = N-l; i >= l; i--) {
				if (i == l-1)
					break;
				lasttemp = M[i-1][N-l];
				M[i-1][N-l] = temp;
				temp = lasttemp;
			}
			temp=lasttemp;
			for (int i = N-l; i >= l; i--) {
				if (i == l-1)
					break;
				lasttemp = M[l-1][i-1];
				 M[l-1][i-1] = temp;
				temp = lasttemp;
			}			
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int N = new Integer(s);
		int M[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			String arr[] = s.split(" ");
			for (int j = 0; j < N; j++) {
				M[i][j] = new Integer(arr[j]);
			}
		}
		//rotateM(M,N,1,0);
		int dir=0;
		for(int l=1;l<=N/2;l++)
		{
			rotateM(M,N,l,dir);
			dir=(dir==0)?1:0;
		}	
		printM(M, N);
	}
}
