class Solution {
    int lps(String str) {
        int n = str.length();
        // Create LPS array to store the longest proper prefix which is also a suffix
        int[] lps = new int[n];
        
        // Length of the previous longest prefix suffix
        int length = 0; 
        int i = 1;
        
        // The LPS value for the first character is always 0
        lps[0] = 0; 
        
        // Fill the lps array
        while (i < n) {
            if (str.charAt(i) == str.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else { 
                // mismatch after length matches
                if (length != 0) {
                    // Do not increment i here
                    length = lps[length - 1];
                } else { 
                    // if length == 0
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        // lps[n-1] contains the length of the longest proper prefix
        // which is also a proper suffix
        return lps[n - 1];
    }
}
