class Solution {
    // Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        if (head == null) return null;

        // Step 1: Create a copy of each node and interweave it with the original list
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.data);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Assign random pointers for the copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Restore the original list and extract the copied list
        curr = head;
        Node dummyHead = new Node(0); // A dummy head for the copied list
        Node copyCurr = dummyHead;

        while (curr != null) {
            Node copy = curr.next;
            curr.next = copy.next; // Restore the original list
            copyCurr.next = copy;  // Build the new copied list
            copyCurr = copy;
            curr = curr.next;
        }

        return dummyHead.next; // Return the head of the copied list
    }
}
