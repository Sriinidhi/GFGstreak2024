class Solution {
    public int totalCount(int k, int[] arr) {
        int total = 0;
        
        for (int num : arr) {
            total += (num + k - 1) / k; // This calculates the ceiling of num/k
        }
        
        return total;
    }
}
