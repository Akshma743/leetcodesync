import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        
        // Initialize the first element as 1
        row.add(1);
        
        // Generate rows up to rowIndex
        for (int i = 1; i <= rowIndex; i++) {
            // Append a 1 at the end to expand the row size
            row.add(1);
            
            // Update the internal elements from right to left
            // This prevents overwriting values needed for the current calculation
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        
        return row;
    }
}
