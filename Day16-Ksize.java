class Solution {
    // Function to find the maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int k, int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < arr.length; i++) {
            // Remove elements not part of this window (i.e., index < i - k + 1)
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            
            // Remove elements smaller than the current element from the deque
            // as they will never be the maximum in this window or any future window.
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }
            
            // Add current element at the end of the deque
            deque.offer(i);
            
            // If we've processed at least k elements, add the front of deque to the result
            if (i >= k - 1) {
                result.add(arr[deque.peek()]);
            }
        }
        
        return result;
    }
}
