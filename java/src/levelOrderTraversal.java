// Source: GeeksForGeeks
// using queue
// Time Complexity: O(n)

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.lang.*;

// A Binary Tree node
class NODE
{
    int data;
    NODE left, right;
    NODE(int item)
    {
        data = item;
        left = right = null;
    }
}
class Drivercode
{


    // driver function to test the above functions
    public static void main(String args[])
    {

        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //NODE root=null;
        while (t > 0)
        {
            HashMap<Integer, NODE> m = new HashMap<Integer, NODE> ();
            int n = sc.nextInt();
            NODE root=null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                NODE parent = m.get(n1);
                if (parent == null)
                {
                    parent = new NODE(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                NODE child = new NODE(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }

            Level_order_traversal g = new Level_order_traversal();
            g.levelOrder(root);
            System.out.println();
            t--;

        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
/*
class NODE
{
    int data;
    NODE left, right;
    NODE(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Level_order_traversal
{
    static Queue <NODE> q = new LinkedList<>();

    static void levelOrder(NODE node)
    {
        if (node == null)
            return;
        else {
            System.out.print(node.data);

            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);

            NODE temp;
            while ((temp = q.poll()) != null) {
                levelOrder(temp);
            }
        }
    }
}