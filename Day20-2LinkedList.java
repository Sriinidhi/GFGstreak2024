class Solution {
    // Define the modulo value as a constant
    private static final long MOD = 1000000007;

    public long multiplyTwoLists(Node first, Node second) {
        long num1 = 0, num2 = 0;
        
        // Traverse the first linked list and form the number
        while (first != null) {
            num1 = (num1 * 10 + first.data) % MOD;
            first = first.next;
        }
        
        // Traverse the second linked list and form the number
        while (second != null) {
            num2 = (num2 * 10 + second.data) % MOD;
            second = second.next;
        }
        
        // Multiply the two numbers and return the result modulo MOD
        return (num1 * num2) % MOD;
    }
}
