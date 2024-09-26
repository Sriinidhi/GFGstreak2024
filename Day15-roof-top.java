class Solution {
    // Function to find the maximum number of consecutive steps
    // to gain an increase in altitude with each step.
    public int maxStep(int arr[]) {
        // Initialize maxSteps to 0 and currentSteps to 0
        int maxSteps = 0, currentSteps = 0;
        
        // Loop through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // If the current building is taller than the previous one
            if (arr[i] > arr[i - 1]) {
                // Increment the current step count
                currentSteps++;
            } else {
                // Otherwise, reset the current step count
                currentSteps = 0;
            }
            
            // Update the max steps if currentSteps is greater
            maxSteps = Math.max(maxSteps, currentSteps);
        }
        
        return maxSteps;
    }
}
