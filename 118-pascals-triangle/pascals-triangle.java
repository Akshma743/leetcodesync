import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        // Base case: if no rows are requested, return the empty list
        if (numRows == 0) {
            return triangle;
        }
        
        // Generate each row one by one
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            
            for (int j = 0; j <= i; j++) {
                // The first and last elements of every row are always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Find the sum of the two elements directly above it
                    int leftAbove = triangle.get(i - 1).get(j - 1);
                    int rightAbove = triangle.get(i - 1).get(j);
                    row.add(leftAbove + rightAbove);
                }
            }
            
            // Add the fully constructed row to the triangle
            triangle.add(row);
        }
        
        return triangle;
    }
}
