class Solution {

    public List<List<Integer>> combinationSum2(
        int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(
            candidates,
            target,
            0,
            new ArrayList<>(),
            result
        );

        return result;
    }

    public void backtrack(
        int[] candidates,
        int target,
        int start,
        List<Integer> current,
        List<List<Integer>> result) {

        // Target achieved
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Skip duplicate at same level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Since array is sorted
            if (candidates[i] > target) {
                break;
            }

            // Choose
            current.add(candidates[i]);

            // Move to next index
            // Same element cannot be reused
            backtrack(
                candidates,
                target - candidates[i],
                i + 1,
                current,
                result
            );

            // Undo
            current.remove(current.size() - 1);
        }
    }
}