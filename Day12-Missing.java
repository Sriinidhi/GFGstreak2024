class Solve {
    int[] findTwoElement(int arr[]) {
        int n = arr.length;
        
        // Initialize variables to store the results
        int repeating = 0, missing = 0;
        
        // Step 1: Calculate the expected sum and square sum for numbers 1 to n
        long expectedSum = (long)n * (n + 1) / 2;
        long expectedSquareSum = (long)n * (n + 1) * (2 * n + 1) / 6;
        
        // Step 2: Calculate the actual sum and square sum from the array
        long actualSum = 0, actualSquareSum = 0;
        for (int num : arr) {
            actualSum += num;
            actualSquareSum += (long)num * num;
        }
        
        // Step 3: Compute the differences
        long diffSum = expectedSum - actualSum; // A - B
        long diffSquareSum = expectedSquareSum - actualSquareSum; // A^2 - B^2
        
        // Step 4: Use the differences to compute missing and repeating numbers
        long sumAplusB = diffSquareSum / diffSum; // A + B
        
        missing = (int)((diffSum + sumAplusB) / 2);
        repeating = (int)(sumAplusB - missing);
        
        return new int[]{repeating, missing};
    }
}
