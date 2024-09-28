class Solution {
    public int minimizeCost(int k, int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];  // dp[i] will store the minimum cost to reach stone i
        
        // Initialize the dp array with maximum possible values
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;  // No cost to start at the first stone
        
        // Iterate over each stone
        for (int i = 0; i < n; i++) {
            // Check jumps from stone i to stone j where i < j ≤ i+k
            for (int j = i + 1; j <= i + k && j < n; j++) {
                dp[j] = Math.min(dp[j], dp[i] + Math.abs(arr[i] - arr[j]));
            }
        }
        
        // The result is the minimum cost to reach the last stone
        return dp[n - 1];
    }
}
