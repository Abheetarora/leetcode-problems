// { Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
boolean isleaf(Node root){
   if(root.left==null&&root.right==null)
       return true;
   else
       return false;
}
void sollb(Node root,ArrayList<Integer> lb){
   Node cur=root.left;
   while(cur!=null){
       if(!isleaf(cur))
           lb.add(cur.data);
       if(cur.left!=null)
          cur=cur.left;
       else
          cur=cur.right;
   }
}
void soll(Node root, ArrayList<Integer> l){
   if(root==null)
     return;
   if(isleaf(root)){
       l.add(root.data);
         return;
   } 
   soll(root.left,l);
   soll(root.right,l);
   
}
void solrb(Node root, ArrayList<Integer> rb){
   Node cur=root.right;
   while(cur!=null){
       if(!isleaf(cur))
           rb.add(cur.data);
       if(cur.right!=null)
          cur=cur.right;
       else
          cur=cur.left;
   }
}

ArrayList <Integer> boundary(Node root)
{  
ArrayList<Integer> ans= new ArrayList<Integer>();
if(root==null)
    return ans;
ans.add(root.data);
if(isleaf(root))
   return ans;
    ArrayList<Integer> lb= new ArrayList<Integer>();
    ArrayList<Integer> l= new ArrayList<Integer>();
    ArrayList<Integer> rb= new ArrayList<Integer>();
    sollb(root,lb);
    soll(root,l);
    solrb(root,rb);
    for(int i:lb){
        ans.add(i);
    }
    for(int i:l){
        ans.add(i);
    }
    int rbs=rb.size();
    for(int i=rbs-1;i>=0;i--){
        ans.add(rb.get(i));
    }
    return ans;
}
}
