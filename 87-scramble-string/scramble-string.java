class Solution {

    java.util.HashMap<String, Boolean> memo = new java.util.HashMap<>();

    public boolean isScramble(String s1, String s2) {

        if (s1.equals(s2)) {
            return true;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        String key = s1 + "#" + s2;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int n = s1.length();

        // Check whether both strings contain same characters
        int[] count = new int[26];

        for (int i = 0; i < n; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        for (int x : count) {
            if (x != 0) {
                memo.put(key, false);
                return false;
            }
        }

        // Try every possible split
        for (int i = 1; i < n; i++) {

            // No swap
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) {

                memo.put(key, true);
                return true;
            }

            // With swap
            if (isScramble(s1.substring(0, i), s2.substring(n - i))
                    && isScramble(s1.substring(i), s2.substring(0, n - i))) {

                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }
}