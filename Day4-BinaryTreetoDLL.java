//User function Template for Java
//question(login to gfg profile to see question: https://www.geeksforgeeks.org/problems/binary-tree-to-dll/
/* class Node
class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}*/

//This function should return head to the DLL

class Solution
{
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
	// Base case
        if (root == null) {
            return null;
        }
        
        // Convert the binary tree to DLL
        Node[] head = new Node[1];
        Node[] prev = new Node[1];
        
        // Helper function to perform in-order traversal and convert the tree to DLL
        inOrderTraversal(root, head, prev);
        
        return head[0];
    }
    
    // Helper function to perform in-order traversal and convert to DLL
    private void inOrderTraversal(Node root, Node[] head, Node[] prev) {
        if (root == null) {
            return;
        }
        
        // Recur on the left subtree
        inOrderTraversal(root.left, head, prev);
        
        // If the previous node is null, it means this is the first node (head) of the DLL
        if (prev[0] == null) {
            head[0] = root;
        } else {
            // Link the current node with the previous node
            prev[0].right = root;
            root.left = prev[0];
        }
        
        // Update the previous node
        prev[0] = root;
        
        // Recur on the right subtree
        inOrderTraversal(root.right, head, prev);
    }
    
    // Utility function to print DLL from head to tail
    public void printForward(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
        System.out.println();
    }
    
    // Utility function to print DLL from tail to head
    public void printBackward(Node tail) {
        Node curr = tail;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.left;
        }
        System.out.println();
    }
}

/*
Input:
      1
    /  \
   3    2
Output:
3 1 2 
2 1 3
Explanation: DLL would be 3<=>1<=>2

Input:
       10
      /   \
     20   30
   /   \
  40   60
Output:
40 20 60 10 30 
30 10 60 20 40
Explanation:  DLL would be 40<=>20<=>60<=>10<=>30.

Expected Time Complexity: O(no. of nodes)
Expected Space Complexity: O(height of the tree)

Constraints:
1 ≤ Number of nodes ≤ 105
0 ≤ Data of a node ≤ 105
*/
