import java.util.Stack;

class Solution {
    static int maxLength(String S) {
        Stack<Integer> stack = new Stack<>();
        // Push -1 to handle edge cases like "()()"
        stack.push(-1);
        int maxLen = 0;

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            // If it's an opening parenthesis, push its index onto the stack
            if (c == '(') {
                stack.push(i);
            } 
            // If it's a closing parenthesis
            else {
                stack.pop(); // Pop the last unmatched '(' or base index

                if (!stack.isEmpty()) {
                    // If stack is not empty, calculate the valid substring length
                    maxLen = Math.max(maxLen, i - stack.peek());
                } else {
                    // If the stack is empty, push the index of ')'
                    stack.push(i);
                }
            }
        }
        return maxLen;
    }
}
