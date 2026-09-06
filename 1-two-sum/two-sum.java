import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a hash map to store the number and its index
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // If the complement is already in the map, we found the pair
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            // Otherwise, store the current number and its index
            map.put(nums[i], i);
        }
        
        // Return an empty array if no solution is found (though the problem guarantees one)
        return new int[] {};
    }
}
