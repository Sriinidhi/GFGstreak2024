
class Solution {
    // Function to return a list of integers denoting the node
    // values of both the BSTs in a sorted order.
    public List<Integer> merge(Node root1, Node root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        // Perform in-order traversal of both trees to get sorted elements
        inorderTraversal(root1, list1);
        inorderTraversal(root2, list2);
        
        // Merge the two sorted lists
        return mergeSortedLists(list1, list2);
    }
    
    // Helper function to perform in-order traversal
    private void inorderTraversal(Node root, List<Integer> list) {
        if (root == null) return;
        
        inorderTraversal(root.left, list);
        list.add(root.data); // Add the node data in sorted order
        inorderTraversal(root.right, list);
    }
    
    // Helper function to merge two sorted lists
    private List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;
        
        // Merge the two sorted lists into one sorted list
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }
        
        // Add remaining elements of list1 if any
        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }
        
        // Add remaining elements of list2 if any
        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }
        
        return mergedList;
    }
}

