package JAVA_DSA_DP;

public class ClimbingStairs {
    // Dynamic Programming approach to calculate the number of ways to climb stairs
    public int climbStairs(int n) {
        // Create an array to store the number of ways to reach each step
        int[] dp = new int[n + 1];
        
        // Base cases:
        dp[0] = 1; // There is 1 way to stay at the ground (do nothing)
        dp[1] = 1; // There is 1 way to reach the first step (1 step)
        
        // Fill the dp array using the recurrence relation:
        // dp[i] = dp[i-1] + dp[i-2], which represents:
        // - Ways to reach step i from step i-1 (1 step)
        // - Ways to reach step i from step i-2 (2 steps)
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        // The answer is the number of ways to reach the nth step
        return dp[n];
    }
}