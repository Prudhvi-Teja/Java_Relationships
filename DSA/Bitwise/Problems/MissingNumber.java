package DSA.Bitwise.Problems;

class MissingNumber {
    public int missingNumber(int[] nums) {
        // Step 1: Initialize xor1 to hold XOR of all numbers from 0 to n
        // xor1 will store the XOR of the complete range [0, n]
        int xor1 = 0;

        // Step 2: Calculate XOR of all numbers from 0 to n
        // Loop through the range [0, n] and XOR each number into xor1
        for (int i = 0; i <= nums.length; i++) {
            xor1 ^= i; // XOR operation accumulates the result
        }

        // Step 3: Initialize sum to hold XOR of all numbers in the array
        // sum will store the XOR of all elements present in nums
        int sum = 0;

        // Step 4: Calculate XOR of all numbers in the given array
        // Loop through the array and XOR each number into sum
        for (int num : nums) {
            sum ^= num; // XOR operation accumulates the result
        }

        // Step 5: Return the missing number
        // XORing xor1 (all numbers in range [0, n]) with sum (all numbers in nums)
        // cancels out the numbers that appear in both, leaving the missing number
        return xor1 ^ sum;
    }
}
