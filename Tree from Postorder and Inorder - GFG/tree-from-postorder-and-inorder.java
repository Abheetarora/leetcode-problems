// { Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}
// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
     Map<Integer, Integer> inorder = new HashMap<>();
    
    Node buildTree(int in[], int post[], int n) {
        // Your code here
        for (int i = 0 ; i < n ; i++) {
            inorder.put(in[i], i);
        }
        
        Node root = new Node(post[n-1]);
        
        for (int i = n - 2 ; i >= 0 ; i--) {
            insert(root, post[i]);
        }
        
        return root;
    }
    
    private Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        
        if (inorder.get(root.data) > inorder.get(val)) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        
        return root;
    }
}
