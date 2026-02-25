package JAVA_DSA_DP;

import java.util.HashMap;
import java.util.Map;

// Memoization:

// The map stores the result for each unique state (index, target) to avoid redundant calculations.
// This improves efficiency by reducing repeated computations.
// Base Case:

// When reaching the last index, check if the target can be achieved with the current number.
// Handle edge cases like 0 carefully (e.g., +0 and -0 are two valid ways).
// Recursive Exploration:

// At each step, explore both adding and subtracting the current number from the target.
// Time Complexity:

// The time complexity is approximately  O(nm)
// , where n is the length of nums and 
// m is the range of possible target values.


// Problem: Target Sum
// Approach: Recursion with Memoization
// Goal: Find the number of ways to add '+' or '-' before each number in the array to achieve the target sum.

class TargetSum {
    // Map to store intermediate results for memoization
    private Map<String, Integer> map;

    public int findTargetSumWays(int[] nums, int target) {
        // Initialize the memoization map
        this.map = new HashMap<>();
        // Start the recursion from index 0 with the given target
        return recur(0, nums, target);
    }

    private int recur(int index, int[] nums, int target) {
        // Create a unique key for the current state (index and target)
        String key = index + "-" + target;

        // If the result for this state is already computed, return it from the map
        if (map.containsKey(key)) {
            return map.get(key);
        }

        // If we haven't reached the last index, continue exploring further
        if (index < nums.length - 1) {
            // Explore both possibilities: adding and subtracting the current number
            map.put(key, recur(index + 1, nums, target - nums[index]) 
                        + recur(index + 1, nums, target + nums[index]));
            return map.get(key);
        } else {
            // Base case: When we reach the last index
            // If the absolute value of the target matches the current number
            if (Math.abs(target) == Math.abs(nums[index])) {
                // If the number is 0, there are 2 ways (+0 and -0)
                if (nums[index] == 0) {
                    return 2;
                }
                // Otherwise, there is only 1 valid way
                return 1;
            } else {
                // If the target cannot be achieved, return 0
                return 0;
            }
        }
    }
}
