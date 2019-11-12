
import java.util.*;
import java.lang.*;
import java.io.*;
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class nodeInsertationInBST
{
    Node root;
    private void inorder(Node node)
    {
        if(node==null)
            return ;
        else
            inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            nodeInsertationInBST tree = new nodeInsertationInBST();
            BST g = new BST();
            Node root = null;
            for(int i=0; i<n; i++)
            {
                int a = sc.nextInt();
                root = g.insert(root, a);
            }
            tree.inorder(root);
            System.out.println();
            t--;
        }
    }
}


/*This is a function problem.You only need to complete the function given below*/
/* Structure of BST node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class BST
{
    /* This function should insert a new node with given data and
      return root of the modified tree  */
    Node insert(Node root, int data)
    {
//        Node new_node = new Node(data);  // Iterative version
//
//        if (root == null) {
//            root = new_node;
//            return root;
//        } else {
//            Node temp = root, prev = root;
//
//            while (temp != null) {
//                if (temp.data == data)
//                    return root;
//                else if (temp.data < data)
//                    temp = temp.right;
//                else
//                    temp = temp.left;
//
//                if (temp != null)
//                    prev = temp;
//            }
//
//            if (prev.data < data)
//                prev.right = new_node;
//            else
//                prev.left = new_node;
//
//            return root;
//        }

        if (root == null) {       // Recursive solution
            return (new Node(data));
        } else {
            if (root.data == data) return root;
            if (root.data < data) root.right = insert(root.right, data);
            else root.left = insert(root.left, data);
        }

        return root;
    }
}
