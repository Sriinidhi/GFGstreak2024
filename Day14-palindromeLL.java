class Solution {
    // Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find the middle of the linked list
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list
        Node secondHalfHead = reverseList(slow);

        // Step 3: Compare the first half and the reversed second half
        Node firstHalfPointer = head;
        Node secondHalfPointer = secondHalfHead;
        while (secondHalfPointer != null) {
            if (firstHalfPointer.data != secondHalfPointer.data) {
                // Optional Step 4: Restore the list before returning
                reverseList(secondHalfHead);
                return false;
            }
            firstHalfPointer = firstHalfPointer.next;
            secondHalfPointer = secondHalfPointer.next;
        }

        // Optional Step 4: Restore the list before returning
        reverseList(secondHalfHead);
        return true;
    }

    // Function to reverse a linked list
    Node reverseList(Node head) {
        Node prev = null, current = head, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
