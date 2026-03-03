package DSA.Bitwise.Problems;

// Importing necessary libraries
// No external libraries are needed here as we use bitwise operations, which are part of Java's core functionality.

class CountingBits {
    public int[] countBits(int n) {
        // Step 1: Initialize an array 'ans' of size n+1 to store the results
        int[] ans = new int[n + 1];

        // Step 2: Loop through each number from 0 to n
        for (int i = 0; i <= n; i++) {
            // Step 3: Calculate the number of set bits (1's) in the binary representation of 'i'
            ans[i] = countSetBits(i);
        }

        // Step 4: Return the result array containing the count of set bits for each number
        return ans;
    }

    /**
     * Helper function to count the number of set bits (1's) in the binary representation of a number 'n'
     */
    private int countSetBits(int n) {
        // Step 1: Initialize a variable 'count' to store the number of 1's
        int count = 0;

        // Step 2: Iterate through all 32 bits (since integers in Java are 32 bits)
        for (int i = 0; i <= 31; i++) {
            // Step 3: Use bitwise AND operation to check if the ith bit is set (1)
            // (n & (1 << i)) checks if the ith bit in 'n' is 1 by shifting 1 left 'i' times
            if ((n & (1 << i)) > 0) {
                // Step 4: If the ith bit is 1, increment the count
                count++;
            }
        }

        // Step 5: Return the count of set bits
        return count;
    }
}