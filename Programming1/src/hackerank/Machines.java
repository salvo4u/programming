package hackerank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Machines {
    static HashMap<String,Integer > red=  new HashMap< String,Integer>();
    static HashMap<String,Integer > blue=  new HashMap< String,Integer>();
    static HashMap<String,Integer > green=  new HashMap< String,Integer>();
    
     static void Ans(String ss)
    {
       int a=getred(ss);
       if(a==-1)
           System.out.println("IMPOSSIBLE");
       else
           System.out.println(a);
        
    }


     static int getblue(String s){
         int n=s.length();
         if(n<=1)
             return -1;
         if(s.equals("ab"))
             return 3; // a(w)+b(B)= ab(b)
         if(blue.get(s)!=null)
             return blue.get(s);
       
         int result=getblue(s.substring(0, n-1));
         if(result==-1 || s.charAt(n-1)!='a'){ // on white paper it is a
             blue.put(s, -1);
             return -1;
         }
         result+=2; // white + itself printing   
         blue.put(s, result);
         return result;
     }
     
     static int getgreen(String s){
         int n=s.length();
         if(n<=1)
             return -1;
         if(green.get(s)!=null)
             return green.get(s);
       
         int result=getblue(s.substring(1, n));
         if(result==-1 || s.charAt(0)!='b'){ // on black paper it is a
             green.put(s, -1);
             return -1;
         }
         result+=2; // white + itself printing   
         green.put(s, result);
         return result;
     }
  
     static int getred(String s){
         int n=s.length();
         if(n<=3)
             return -1;
         if(red.get(s)!=null)
             return red.get(s);
       
         int result=-1;
         for(int i=1;i<n-2;i++){
             
             int b=getblue(s.substring(0,i+1));
             int g=getgreen(s.substring(i+1,n));
             
             if(b!=-1 && g!=-1){
                if(result==-1)
                    result=b+g+1;
                else if(result>b+g+1)
                 result=b+g+1;
             }
         }
         red.put(s, result);
         return result;
     }
     

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            String arr[] = s.split(" ");
            int N = new Integer(arr[0]);
            
            for (int i = 0; i < N; i++) {
                String ss = br.readLine();    
                Ans(ss);
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
