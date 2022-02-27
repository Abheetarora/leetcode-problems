// { Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}// } Driver Code Ends


class Solution
{
    	private static Node buildTree(int[] preOrder, int preStart, int preEnd,int[] inOrder, int inStart, int inEnd,HashMap<Integer, Integer> map) {
		
		if(preStart>preEnd && inStart>inEnd) return null;
		
		Node root=new Node(preOrder[preStart]);
	
		int inroot=map.get(root.data);
		int numleft=inroot-inStart;  
		
		root.left=buildTree(preOrder,preStart+1,preStart+numleft,inOrder,inStart,inroot-1,map);
		root.right=buildTree(preOrder,preStart+numleft+1,preEnd,inOrder,inroot+1,inEnd,map);

		return root;
	}
    
    
    public static Node buildTree(int inOrder[], int preOrder[], int n)
    {
        HashMap <Integer,Integer> map=new HashMap<>();
		for(int i=0;i<inOrder.length;i++) {
			map.put(inOrder[i], i);
		}
		
		return buildTree(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1,map);
    }
}
