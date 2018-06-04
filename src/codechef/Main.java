package codechef;

import java.io.*;
class Main {
    static Node r = new Node(-1,-1);
    public static void main(String[] args) throws IOException {
        BufferedReader k = new BufferedReader(new InputStreamReader(System.in));
        String s = k.readLine();
        long n;
        while(s!=null&&!s.equalsIgnoreCase("")) {
            n = Long.parseLong(s);
            System.out.println(max(n));
            s = k.readLine();
        }
    }
    public static long max(long n) {
        if(n<12)
            return n;
        else {
            long n1=find(n/2);
            if(n1==-1)
                n1=max(n/2); insert(n/2,n1);
            long n2=find(n/3);
            if(n2==-1)
                n2=max(n/3); insert(n/3,n2);
            long n3=find(n/4);
            if(n3==-1)
                n3=max(n/4); insert(n/4,n3);
            return n1+n2+n3;
        }
    }
    public static void insert(long n,long v) {
        Node temp = r;
        while(temp!=null) {
            if(n<temp.name) {
                if(temp.left!=null)
                    temp = temp.left;
                else {
                    temp.left = new Node(n,v);
                    break;
                }
            }
            else {
                if(temp.right!=null)
                    temp = temp.right;
                else {
                    temp.right = new Node(n,v);
                    break;
                }
            }
        }
    }
    public static long find(long n) {
        Node temp = r;
        while(temp!=null) {
            if(n<temp.name)
                temp = temp.left;
            else if(n>temp.name)
                temp = temp.right;
            else
                return temp.value;
        }
        return -1;
    }
}
class Node {
    long name;
    long value;
    Node left,right;
    public Node(long n,long v) {
        name = n;
        value = v;
    }
} 