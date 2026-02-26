package JAVA_DSA_DP;

// Problem: House Robber
// Approach: Optimized Dynamic Programming (Space Complexity: O(1))
// Goal: Maximize the amount of money robbed without robbing two adjacent houses.

class HouseRobber {
    public int rob(int[] nums) {
        // Step 1: Get the number of houses
        int n = nums.length;

        // Step 2: Create a DP array to store the maximum money that can be robbed
        // dp[i] represents the maximum money robbed starting from house i
        int[] dp = new int[n + 1];

        // Step 3: Base cases
        // If we start at the last house, the maximum money is the amount in that house
        dp[n - 1] = nums[n - 1];
        // If we are beyond the last house, no money can be robbed
        dp[n] = 0;

        // Step 4: Fill the DP array from the second last house to the first house
        for (int i = n - 2; i >= 0; i--) {
            // Either rob the current house and skip the next (nums[i] + dp[i + 2])
            // Or skip the current house and take the maximum money from the next house (dp[i + 1])
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }

        // Step 5: The maximum money robbed starting from the first house is stored in dp[0]
        return dp[0];
    }
}