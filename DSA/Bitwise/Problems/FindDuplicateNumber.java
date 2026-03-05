package DSA.Bitwise.Problems;

class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        // Binary Search Approach to find the duplicate number
        // Step 1: Initialize search range
        int start = 1; // Smallest possible number in nums
        int end = nums.length - 1; // Largest possible number (n)
        int ans = 0; // Variable to store the duplicate number

        // Step 2: Perform binary search
        while (start <= end) {
            // Calculate the middle of the current range
            int mid = (start + end) / 2;

            // Step 3: Count the numbers less than or equal to 'mid'
            int count = 0; // Variable to count numbers <= mid
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            // Step 4: Check if the duplicate number is in the lower half or upper half
            if (count <= mid) {
                // If count is less than or equal to mid, the duplicate is in the upper half
                start = mid + 1; // Adjust the search range to upper half
            } else {
                // If count is greater than mid, the duplicate is in the lower half
                ans = mid; // Update the answer to mid
                end = mid - 1; // Adjust the search range to lower half
            }
        }

        // Step 5: Return the duplicate number
        return ans;
    }
}
