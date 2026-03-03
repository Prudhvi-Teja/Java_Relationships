package DSA.Bitwise.Problems;

class SingleNumber {
    public int singleNumber(int[] nums) {
        // Step 1: Initialize a variable 'ans' to store the result
        // 'ans' will hold the XOR of all numbers, starting from 0
        int ans = 0;

        // Step 2: Iterate through each number in the array 'nums'
        for (int num : nums) {
            // Explanation of XOR operation:
            // - XOR cancels out duplicate numbers because x ^ x = 0
            // - XOR with 0 leaves the number unchanged: x ^ 0 = x
            // - This ensures that all duplicate numbers cancel out and only the single number remains
            ans ^= num; // Perform XOR operation between 'ans' and the current number
        }

        // Step 3: Return the result stored in 'ans'
        // At this point, 'ans' contains the single number because all duplicates were canceled out
        return ans;
    }
}