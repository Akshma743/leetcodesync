class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        m, n = len(s1), len(s2)
        
        # Base check for length mismatch
        if m + n != len(s3):
            return False
            
        # Optimize space by ensuring s2 is the shorter string
        if m < n:
            s1, s2 = s2, s1
            m, n = n, m
            
        # Initialize 1D DP table
        dp = [False] * (n + 1)
        dp[0] = True
        
        # Initialize base case for matching s2 only
        for j in range(1, n + 1):
            dp[j] = dp[j-1] and s2[j-1] == s3[j-1]
            
        # Fill the DP table
        for i in range(1, m + 1):
            dp[0] = dp[0] and s1[i-1] == s3[i-1]
            for j in range(1, n + 1):
                dp[j] = (dp[j] and s1[i-1] == s3[i+j-1]) or (dp[j-1] and s2[j-1] == s3[i+j-1])
                
        return dp[n]
