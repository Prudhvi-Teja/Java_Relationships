package JAVA_DSA_DP;

// Problem: Coin Change
// Approach: Dynamic Programming (Bottom-Up)
// Goal: Find the fewest number of coins required to make up a given amount.
// If it is not possible to make the amount, return -1.

import java.util.Arrays;

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // Step 1: Create a DP array where dp[i] represents the minimum coins needed for amount 'i'.
        // Initialize the array with a value greater than the maximum possible (amount + 1).
        // This represents that the amount is initially unreachable.
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        
        // Step 2: Base Case - To make amount 0, we need 0 coins.
        dp[0] = 0;
        
        // Step 3: Iterate through all amounts from 1 to 'amount'.
        for (int amt = 1; amt <= amount; amt++) {
            // Check each coin denomination to find the minimum coins required for 'amt'.
            for (int coin : coins) {
                // If the current coin can contribute to the amount (i.e., amt - coin >= 0),
                // update dp[amt] with the minimum coins required.
                if (amt - coin >= 0) {
                    dp[amt] = Math.min(dp[amt], 1 + dp[amt - coin]);
                }
            }
        }
        
        // Step 4: Check the result. If dp[amount] is still the initialized value (amount + 1),
        // it means the amount cannot be formed with the given coins.
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
