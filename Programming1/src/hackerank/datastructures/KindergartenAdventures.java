package hackerank.datastructures;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//https://www.hackerrank.com/challenges/kindergarten-adventures/problem
public class KindergartenAdventures {
	/*
     * Complete the solve function below.
     */
    static int solve(int[] t) {
        /*
         * Return the ID
         */
        int maxcom = -1;
        int student = 0;
        for(int i=0;i<t.length;i++){
            int completed = 0;
            
            for(int j=0;j<t.length;j++){
                int s = ((i+j)+i)%(t.length);
                if(t[j]<=s)
                    completed++;
            }
            System.out.println(i+1 + "  " + completed);
            if(maxcom<completed){
                maxcom = completed;
                student = (i+1);
            }
        }
    return student;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        

        int tCount = Integer.parseInt(scanner.nextLine().trim());

        int[] t = new int[tCount];

        String[] tItems = scanner.nextLine().split(" ");

        for (int tItr = 0; tItr < tCount; tItr++) {
            int tItem = Integer.parseInt(tItems[tItr].trim());
            t[tItr] = tItem;
        }

        int id = solve(t);
        System.out.println(id);
       
    }

}
