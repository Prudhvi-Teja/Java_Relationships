package DSA.Bitwise.Problems;

class NumberaOf1Bits {
    public int hammingWeight(int n) {
        // Initialize a counter to keep track of the number of set bits (1s)
        int count = 0;

        // Iterate through all 32 bits of the integer
        // Note: An integer in Java has 32 bits, so we loop from 0 to 31
        for (int i = 0; i <= 31; i++) {
            // Use bitwise AND to check if the i-th bit is set (1)
            // (1 << i) shifts the number 1 to the left by i positions, creating a mask
            if ((n & (1 << i)) != 0) {
                // If the result of the AND operation is not zero, the bit is set
                count++; // Increment the counter for each set bit found
            }
        }

        // Return the total count of set bits in the binary representation of n
        return count;
    }
}
// Bitwise AND (n&(1<<i)):

// Checks if the i-th bit is set by comparing it with a bit mask.
// If result is non-zero, the bit is set.
// Left Shift (1<<i):

// Shifts the binary number 1 left by i positions, creating a mask to check specific bits.
// Looping through 32 bits:

// Ensures all bits of the integer are checked, as Java integers are 32 bits.
// Time Complexity:

// O(32), since the loop runs for a fixed number of iterations.
