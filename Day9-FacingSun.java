class Solution {
    // Returns count buildings that can see sunlight
  public static int countBuildings(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        // Initialize the count of buildings that can see the sunrise.
        int count = 1; // The first building always sees the sunrise
        int maxHeight = height[0]; // Start with the height of the first building

        // Iterate over the rest of the buildings
        for (int i = 1; i < height.length; i++) {
            // If the current building is taller than the max height so far
            if (height[i] > maxHeight) {
                count++; // This building can see the sunrise
                maxHeight = height[i]; // Update the max height
            }
        }

        return count;
    }
}
