package JAVA_DSA_DP;

class PartionSubSet {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        // Step 1: Calculate the sum of all elements in the array
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // Step 2: If the total sum is odd, it cannot be partitioned into two equal subsets
        if (sum % 2 != 0) {
            return false;
        }

        // Step 3: Calculate the target sum for each subset (half of the total sum)
        int target = sum / 2;

        // Step 4: Create a memoization table to store results of subproblems
        // dp[index][target] represents whether it's possible to achieve 'target' sum using elements from 'index' onwards
        Boolean[][] dp = new Boolean[n][target + 1];

        // Step 5: Call the recursive helper function to solve the problem
        return rec(0, target, nums, dp);
    }

    private boolean rec(int index, int target, int[] nums, Boolean[][] dp) {
        // Base Case 1: If the target becomes negative, it's not possible
        if (target < 0) {
            return false;
        }

        // Base Case 2: Check if the result for this subproblem is already computed
        if (dp[index][target] != null) {
            return dp[index][target];
        }

        // Base Case 3: If we reach the last element in the array
        if (index == nums.length - 1) {
            // Check if the target matches the current element or is zero
            if (target == 0 || target == nums[index]) {
                return true;
            }
            return false;
        }

        // Recursive Case: Explore two possibilities
        // 1. Include the current element in the subset
        // 2. Exclude the current element from the subset
        boolean isPossible = rec(index + 1, target - nums[index], nums, dp) || rec(index + 1, target, nums, dp);

        // Store the result in the memoization table and return it
        dp[index][target] = isPossible;
        return isPossible;
    }
}