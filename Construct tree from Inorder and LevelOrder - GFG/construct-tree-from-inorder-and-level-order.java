// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }    
        public void setLeft(Node left) 
    {
        this.left = left;
    }
  
    public void setRight(Node right) 
    {
        this.right = right;
    }
        
    
}


class ConstructBT
{
    Node root;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        
	        int inord[] = new int[n];
	        int level[] = new int[n];
	        for(int i = 0; i < n; i++)
	            inord[i] = sc.nextInt();
	            
	        for(int i = 0; i < n; i++)
	             level[i] = sc.nextInt();
	             
	        GfG g = new GfG();
	        Node node =  g.buildTree(inord, level);
	        printPreOrder(node);
	        System.out.println();
	        
	        
	    }
    }
    
   static void printPreOrder(Node node)
   {
       if(node == null)
          return;
          
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
   }
}
// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{
    Node buildTree(int inorder[], int level[])
    {
        Node root = null;
        return solve(root,inorder,level,0,level.length-1);
        
        //your code here
    }
    Node solve(Node root,int inorder[],int level[],int instart,int inend)
    {
        if(instart>inend)
        {
            return null;
        }
        if(instart == inend)
        {
            return new Node(inorder[instart]);
        }
        int index = 0;
        int flag = 0;
        for(int i=0;i<level.length;i++)
        {
            int data = level[i];
            for(int j=instart;j<inend;j++)
            {
                if(inorder[j] == data)
                {
                    root = new Node(data);
                    index = j;
                    flag =1;
                    break;
                }
            }
            if(flag == 1)
            {
                break;
            }
        }
        root.setLeft( solve( root,inorder,level,instart,index-1 ) );
        root.setRight( solve( root,inorder,level,index+1,inend ) );
        
        return root;
    }
    
   
}


