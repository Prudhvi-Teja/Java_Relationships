package JAVA_DSA_DP;
import java.util.*;
class IntegerReplacement {
    // Step 1: Declare a HashMap to store previously computed results (Memoization)
    private Map<Integer, Integer> map;

    public int integerReplacement(int n) {
        // Base case: If n is already 1, no operations are needed
        if (n == 1) return 0;

        // Initialize the HashMap for memoization
        this.map = new HashMap<>();

        // Prepopulate the map with known values
        // 1 -> 0 operations needed as 1 is the target
        map.put(1, 0);

        // Edge case: Maximum integer value in Java, precomputed to avoid overflow
        map.put(2147483647, 32); 

        // Start the recursive process to calculate the minimum steps
        return rec(n);
    }

    private int rec(int n) {
        // Step 2: Check if the result for this number is already computed
        // If yes, return the stored value from the map (Memoization)
        if (map.containsKey(n)) {
            return map.get(n);
        }

        // Step 3: Variable to store the result for the current number
        int ans = 0;

        // Step 4: If the number is even, divide it by 2 and recursively calculate steps
        if (n % 2 == 0) {
            ans = rec(n / 2) + 1; // +1 for the current operation
        } else {
            // Step 5: If the number is odd, there are two options:
            // Option 1: Subtract 1 (n - 1)
            // Option 2: Add 1 (n + 1)
            // Recursively calculate steps for both options and take the minimum
            ans = Math.min(rec(n - 1), rec(n + 1)) + 1; // +1 for the current operation
        }

        // Step 6: Store the computed result in the map for future reference
        map.put(n, ans);

        // Step 7: Return the result for the current number
        return ans;
    }
}