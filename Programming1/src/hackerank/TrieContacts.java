package hackerank;
//https://www.hackerrank.com/challenges/ctci-contacts/problem
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
class Node{
    char ch;
    ArrayList<Node> childList = new ArrayList<Node>();//
    boolean isWord;
    int words = 0;
    Node containsCh(char ch){
        for(int i=0; i<childList.size(); i++){
            Node x = childList.get(i);
            if(x.ch == ch)
                return x;
        }
        return null;
    }
    
    Node find(String str){
    	Node n = null;
    	if(str.length()>0)
    		n = this.containsCh(str.charAt(0));
        if(str.length()==1)
            return n;
        if(n!=null ){
            return n.find(str.substring(1));
        }
        else
            return null;
   }
   
   int countWords(Node n){
	    if(n==null)
	    	return 0;
        ArrayList<Node> list = n.childList;
        if(list==null)
        	return 0;
        int count = 0;
        if(n.isWord)
            return 1;
        for(int i=0; i<list.size(); i++){
           Node x = list.get(i);
           count+=(countWords(x));
        }
        if(n.isWord)
        	count++;
       return count;
   }
   
   int countWords1(Node n){
	   if(n==null)
		   return 0;
	   return n.words;
   }
    void add(String str){
    	 if(str.equals("") || str == null)
    		 return;
    	 
         Node n = this.containsCh(str.charAt(0));
         
         if(n!=null){
             n.add(str.substring(1));
             n.words++;
         }else{
             Node x = new Node();
             x.ch = str.charAt(0);
             childList.add(x);
             if(str.length()==1)
            	 x.isWord = true;
             x.add(str.substring(1));
            
         }
      }
    
}

public class TrieContacts {
        
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        Node trie = new Node();
        trie.ch = '0';
        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");

            String op = opContact[0];

            String contact = opContact[1];
            
            if(op.equals("add")){
                trie.add(contact);
            }
            if(op.equals("find")){
               System.out.println(trie.countWords1(trie.find(contact)));
            }
        }
        
        scanner.close();
    }
}
