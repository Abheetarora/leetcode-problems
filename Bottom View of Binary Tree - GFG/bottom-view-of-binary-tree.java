// { Driver Code Starts
//Initial Template for Java


//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
 
    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}



class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Solution ob = new Solution();
			    ArrayList <Integer> res = ob.bottomView(root);
			    for (Integer num : res) System.out.print (num + " ");
		     	System.out.println();
	        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return a list containing the bottom view of the given tree.
   
      //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    
    public class qt{
      int lvl;
      Node node;
      qt(int lvl,Node node){
          this.lvl=lvl;
          this.node=node;
      }
  }
 
   public ArrayList <Integer> bottomView(Node root)
   {
      ArrayList<Integer>ans=new ArrayList<>();
      if(root==null)
      return ans;
      
      TreeMap<Integer,ArrayList<Integer>>m=new TreeMap<>();
      int lvl=0;
      Queue<qt>q=new LinkedList<>();
      q.add(new qt(0,root));
      while(!q.isEmpty()){
          qt cur=q.poll();
          Node node=cur.node;
          int lv=cur.lvl;
          if(m.containsKey(lv)){
              m.get(lv).add(node.data);
          }else{
              ArrayList<Integer>temp=new ArrayList<>();
              temp.add(node.data);
              m.put(lv,temp);
          }
          if(node.left!=null){
              q.add(new qt(lv-1,node.left));
          }
          if(node.right!=null){
              q.add(new qt(lv+1,node.right));
          }
      }
      for(Map.Entry<Integer,ArrayList<Integer>>e:m.entrySet()){
          //System.out.println(e);
          int temp = (e.getValue().get(e.getValue().size()-1));
          //System.out.println(temp);
          ans.add(temp);
      }
      return ans;
   }
    
}