class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
    ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        
        // Separate the positive and negative numbers
        for (int num : arr) {
            if (num >= 0) {
                pos.add(num);
            } else {
                neg.add(num);
            }
        }

        // Merging them back in alternate fashion
        int i = 0, j = 0, k = 0;
        while (i < pos.size() && j < neg.size()) {
            arr.set(k++, pos.get(i++));  // Add positive element
            arr.set(k++, neg.get(j++));  // Add negative element
        }

        // If there are remaining positive numbers, add them
        while (i < pos.size()) {
            arr.set(k++, pos.get(i++));
        }

        // If there are remaining negative numbers, add them
        while (j < neg.size()) {
            arr.set(k++, neg.get(j++));
        }
    }
}
