
//Problem : https://www.geeksforgeeks.org/problems/mirror-tree/
// User function Template for Java

// function Template for Java

// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)
   {
        data = item;
        left = right = null;
    }
} */

class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Your code here
        //check if node is null then return
        if(node == null){ return;}
        
        //node's left subtree recur
        mirror(node.left);
        //node's right subtree recur
        mirror(node.right);
        
        //swapping left right of the node
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        
        /*working:
        here first it goes to last node having l, r and swaps and
        returns back to the root perfomes same recur.
            10
            / \
           20 30
          / \
         40 60
         
Start at root (10):
Call mirror(10).
Recursively call mirror(20) for the left subtree and mirror(30) for the right subtree.
Mirror left subtree (20):
Call mirror(20).
Recursively call mirror(40) for the left subtree and mirror(60) for the right subtree.
Mirror leaf nodes:
Call mirror(40) and mirror(60).
Since both are leaf nodes, nothing is swapped. Return to node 20.
Swap children of 20:
Swap the left and right children of 20.
Now, 20 has:
Left child: 60
Right child: 40
Mirror right subtree (30):
Call mirror(30).
Since 30 is a leaf node, nothing is swapped. Return to node 10.
Swap children of 10:
Swap the left and right children of 10.
Now, 10 has:
Left child: 30
Right child: 20 (with its mirrored children).
Now we have mirrored BT
            10
            / \
           30  20
               / \
              60 40
*/
        
        
    }
    
    //Functtion for inorder traversal of BT
    void inOrder(Node node)
    {
        
        if(node != null){inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);}
    }
    
    /*
    working of inOrderTraversal of:
            10
            / \
           30  20
               / \
              60 40
Starting from the root (10):
Traverse left subtree of 10 (i.e., node 30).
At node 30:
30 has no left child, so the left subtree is null, and we skip it.
Visit root (30): print 30.
30 has no right child, so the right subtree is null, and we skip it.
Return to the parent node (10).
Output so far: 30

Back at node 10:
After visiting the left subtree (30), visit root (10): print 10.
Now, traverse the right subtree of 10 (i.e., node 20).
Output so far: 30 10

At node 20:
Traverse left subtree of 20 (i.e., node 60).
At node 60:
60 has no left child, so the left subtree is null, and we skip it.
Visit root (60): print 60.
60 has no right child, so the right subtree is null, and we skip it.
Return to the parent node (20).
Output so far: 30 10 60

Back at node 20:
After visiting the left subtree (60), visit root (20): print 20.
Now, traverse the right subtree of 20 (i.e., node 40).
At node 40:
40 has no left child, so the left subtree is null, and we skip it.
Visit root (40): print 40.
40 has no right child, so the right subtree is null, and we skip it.
Return to the parent node (20), but both subtrees of 20 have now been visited.
Output so far: 30 10 60 20 40
    */
}
