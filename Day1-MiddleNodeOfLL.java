/*
Problem Statement Link:
https://www.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/

Approach:
To efficiently find the middle of the linked list, we can utilize the two-pointer technique.
This method involves two pointers (or references) that traverse the list at different speeds: a slow pointer and a fast pointer.
Slow Pointer: Moves one step at a time.
Fast Pointer: Moves two steps at a time.
When the fast pointer reaches the end of the linked list, the slow pointer will be at the middle.
This approach ensures that we find the middle node in a single pass through the linked list.

Conclusion:
The two-pointer technique offers an optimal solution to finding the middle of a linked list in,
O(n) time and O(1) space.
This approach is both efficient and simple to implement.

*/


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    int getMiddle(Node head) {
        // Your code here.
     
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null)
        {
            if(head == null) return 0;
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}
