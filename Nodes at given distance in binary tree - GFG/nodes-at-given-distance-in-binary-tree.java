// { Driver Code Starts
//Initial Template for Java

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
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
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
// }

class Solution
{
   Node targetAddress = null;
   public ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
   {
       ArrayList<Integer> al = new ArrayList<>();
       HashMap<Node, Node> hm = new HashMap<>();
       getParentPointers(hm, root);

       getTargetAddress(root, target);

       Queue<Node> q = new ArrayDeque<>();
       HashMap<Node, Boolean> visited = new HashMap<>();
       q.offer(targetAddress);
       visited.put(targetAddress, true);
       int distance = 0;
       while (!q.isEmpty() && distance != k) {
           int size = q.size();
           for (int i = 0; i < size; i++) {
               Node n = q.poll();
               if (n.left != null) {
                   if (!visited.containsKey(n.left)) {
                       visited.put(n.left, true);
                       q.offer(n.left);
                   }
               }
               if (n.right != null) {
                   if (!visited.containsKey(n.right)) {
                       visited.put(n.right, true);
                       q.offer(n.right);
                   }
               }
               if (hm.get(n) != null) {
                   if (!visited.containsKey(hm.get(n))) {
                       visited.put(hm.get(n), true);
                       q.offer(hm.get(n));
                   }
               }
           }
           distance++;
       }
       while (!q.isEmpty()) {
           al.add(q.poll().data);
       }
       Collections.sort(al);
       return al;
   }
   public void getParentPointers(HashMap<Node, Node> hm, Node root) {
       Queue<Node> q = new ArrayDeque<>();
       q.offer(root);
       Node parent = null;
       while (!q.isEmpty()) {
           Node curr = q.poll();
           parent = curr;
           if (curr.left != null) {
               q.offer(curr.left);
               hm.put(curr.left, parent);
           }
           if (curr.right != null) {
               q.offer(curr.right);
               hm.put(curr.right, parent);
           }
       }
   }
   public Node getTargetAddress(Node root, int target) {
       if (root == null)
           return null;
       getTargetAddress(root.left, target);
       if (root.data == target) {
           targetAddress = root;
       }
       getTargetAddress(root.right, target);
       return root;
   }
   
};