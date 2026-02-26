package JAVA_DSA_DP;

// Problem: House Robber
// Approach: Optimized Dynamic Programming (Space Complexity: O(1))
// Goal: Maximize the amount of money robbed without robbing two adjacent houses.

class HouseRobber {
    public int rob(int[] nums) {
        // Edge case: If there's only one house, rob it
        if (nums.length == 1) return nums[0];
        // Variables to store the last two states
        int prev2 = 0; // Money robbed from two houses before
        int prev1 = 0; // Money robbed from the last house

        // Iterate through each house
        for (int num : nums) {
            // Calculate the maximum money robbed till the current house
            int curr = Math.max(prev1, prev2 + num);
            // Update states for the next iteration
            prev2 = prev1;
            prev1 = curr;
        }

        // The final value of prev1 contains the maximum money robbed
        return prev1;
    }
}