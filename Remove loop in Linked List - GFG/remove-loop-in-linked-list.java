// { Driver Code Starts
// driver code

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
}

class GFG
{
    public static Node newNode(int data){
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }
    
    public static void makeLoop(Node head, int x){
        if (x == 0)
            return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x)
        {
            curr = curr.next;
            currentPosition++;
        }
        
        while (last.next != null)
            last = last.next;
        last.next = curr;
    }
    
    public static boolean detectLoop(Node head){
        Node hare = head.next;
        Node tortoise = head;
        while( hare != tortoise )
        {
            if(hare==null || hare.next==null) return false;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }
    
    public static int length(Node head){
        int ret=0;
        while(head!=null)
        {
            ret += 1;
            head = head.next;
        }
        return ret;
    }
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--> 0)
        {
            int n = sc.nextInt();
            
            int num = sc.nextInt();
            Node head = newNode(num);
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = newNode(num);
                tail = tail.next;
            }
            
            int pos = sc.nextInt();
            makeLoop(head, pos);
            
            Solution x = new Solution();
            x.removeLoop(head);
            
            if( detectLoop(head) || length(head)!=n )
                System.out.println("0");
            else
                System.out.println("1");
        }
    }
}
// } Driver Code Ends


/*
class Node
{
    int data;
    Node next;
}
*/

class Solution
{
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
         if(head==null || head.next==null){
           return;
       }
       
       Node slow=head,fast=head;
       Node ptr1=head,ptr2=null;
       
       while(fast!=null && fast.next!=null){
           slow=slow.next;
           fast=fast.next.next;
           if(slow==fast){
               //ptr2 is node where 
               //slow and fast are meeting
               ptr2=slow;
               break;
           }
       }
       
       //if there is no cycle
       if(ptr2==null){
           return;
       }
       
       //start ptr1 from head and
       //ptr2 from meeting pt of slow
       //and fast, then point where 
       //ptr1 and ptr2 will meet 
       //will be starting point of loop
       while(ptr1!=ptr2){
           ptr1=ptr1.next;
           ptr2=ptr2.next;
       }
       
       //start traversing from 
       //starting of loop till
       //last node of loop
       // and point it's next pointer
       //to null;
       Node temp=ptr1;
       while(temp.next!=ptr1){
           temp=temp.next;
       }
       temp.next=null;
        // code here
        // remove the loop without losing any nodes
    }
}