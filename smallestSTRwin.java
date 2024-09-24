class Solution {
    // Function to find the smallest window in the string s consisting
    // of all the characters of string p.
    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length()) {
            return "-1";
        }
        
        // Array to keep the count of characters in p
        int[] pFreq = new int[26];
        for (char c : p.toCharArray()) {
            pFreq[c - 'a']++;
        }

        // Array to keep the count of characters in the current window
        int[] sFreq = new int[26];
        
        int minLength = Integer.MAX_VALUE; // Store the minimum length of the window
        int start = 0;                     // Start index of the minimum window
        int count = 0;                     // Count of characters matched so far
        int left = 0;                      // Left pointer of the window

        for (int right = 0; right < s.length(); right++) {
            // Add the current character to the window
            char currentChar = s.charAt(right);
            sFreq[currentChar - 'a']++;
            
            // If the current character is part of p and count in window is less than or equal to count in p
            if (pFreq[currentChar - 'a'] != 0 && sFreq[currentChar - 'a'] <= pFreq[currentChar - 'a']) {
                count++;
            }
            
            // If all characters are matched, try to minimize the window
            while (count == p.length()) {
                // Update the minimum length and starting index if the current window is smaller
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }
                
                // Remove the leftmost character from the window
                char leftChar = s.charAt(left);
                sFreq[leftChar - 'a']--;
                
                // If the leftmost character is part of p and it is not enough in the window
                if (pFreq[leftChar - 'a'] != 0 && sFreq[leftChar - 'a'] < pFreq[leftChar - 'a']) {
                    count--;
                }
                
                left++;
            }
        }

        // If no window found, return "-1"
        if (minLength == Integer.MAX_VALUE) {
            return "-1";
        }
        
        // Return the minimum length window
        return s.substring(start, start + minLength);
    }
}
