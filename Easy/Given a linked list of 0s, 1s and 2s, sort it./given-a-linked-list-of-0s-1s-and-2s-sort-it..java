//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(s[i]));
                tail = tail.next;
            }

            head = new Solution().segregate(head);
            printList(head, out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node head,PrintWriter out)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head){
        Node zeroHead = null;
        Node zeroTell = null;
        
        Node oneHead = null;
        Node oneTell = null;
        
        Node twoHead = null;
        Node twoTell = null;
        
        
        Node ptr = head;
        
        while(ptr != null){
            
            if(zeroHead == null && ptr.data == 0){
                Node newNode = new Node(0);
                zeroHead = newNode;
                zeroTell = newNode;
            }
            else if(zeroHead != null && ptr.data == 0){
                Node newNode = new Node(0);
                zeroTell.next = newNode;
                zeroTell = zeroTell.next;
            }
            
            
            if(oneHead == null && ptr.data == 1){
                Node newNode = new Node(1);
                oneHead = newNode;
                oneTell = newNode;
            }
            else if(oneHead != null && ptr.data == 1){
                Node newNode = new Node(1);
                oneTell.next = newNode;
                oneTell = oneTell.next;
            }
            
            
            if(twoHead == null && ptr.data == 2){
                Node newNode = new Node(2);
                twoHead = newNode;
                twoTell = newNode;
            }
            
            else if(twoHead != null && ptr.data == 2){
                Node newNode = new Node(2);
                twoTell.next = newNode;
                twoTell = twoTell.next;
            }
            
            ptr = ptr.next;
        }
        if(zeroHead == null && oneHead == null){
            return twoHead;
        }

        if(zeroHead == null){
            oneTell.next = twoHead;
            return oneHead;
        }
        
        if(oneHead == null){
            zeroTell.next = twoHead;
            return zeroHead;
        }

        zeroTell.next = oneHead;
        oneTell.next = twoHead;

        return zeroHead;
    }
}


