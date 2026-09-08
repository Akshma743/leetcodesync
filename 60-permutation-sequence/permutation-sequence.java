class Solution {
    public String getPermutation(int n, int k) {

        List<Integer> numbers = new ArrayList<>();

        // Store 1, 2, 3, ..., n
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // Calculate (n-1)!
        int factorial = 1;
        for (int i = 1; i < n; i++) {
            factorial *= i;
        }

        StringBuilder ans = new StringBuilder();

        k--; // Convert k to 0-based

        while (n > 0) {

            int index = k / factorial;

            ans.append(numbers.get(index));
            numbers.remove(index);

            k = k % factorial;

            n--;

            if (n > 0) {
                factorial = factorial / n;
            }
        }

        return ans.toString();
    }
}