class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        
    // Create a stack to store opening brackets
        Stack<Character> stack = new Stack<>();

        // Traverse through the string
        for (int i = 0; i < x.length(); i++) {
            char ch = x.charAt(i);

            // Push opening brackets onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // When encountering closing brackets
            else if (ch == ')' || ch == '}' || ch == ']') {
                // If stack is empty, return false
                if (stack.isEmpty()) {
                    return false;
                }

                // Pop the top element from the stack
                char top = stack.pop();

                // Check if the top element matches the current closing bracket
                if ((ch == ')' && top != '(') || 
                    (ch == '}' && top != '{') || 
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If stack is empty, return true; else return false
        return stack.isEmpty();
    }        
}
