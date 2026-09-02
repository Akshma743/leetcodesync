class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            // Allow the element if it's one of the first two elements 
            // or if it's greater than the element placed two positions back
            if (i < 2 || n > nums[i - 2]) {
                nums[i] = n;
                i++;
            }
        }
        return i;
    }
}
