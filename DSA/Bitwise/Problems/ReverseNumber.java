package DSA.Bitwise.Problems;


class ReverseNumber {
    public int reverse(int x) {
        // Initialize variable to hold the reversed number
        int reverseNumber = 0;

        // Process each digit until the number becomes 0
        while (x != 0) {
            // Step 1: Extract the last digit of the number
            int lastNum = x % 10;

            // Step 2: Calculate the potential new reversed number
            int temp = (reverseNumber * 10) + lastNum;

            // Step 3: Check for overflow
            // Explanation: If temp doesn't match reverseNumber after undoing the last operation, overflow has occurred
            if ((temp - lastNum) / 10 != reverseNumber) {
                return 0; // Return 0 in case of overflow
            }

            // Step 4: Update the reversed number and remove the last digit from x
            reverseNumber = temp;
            x = x / 10; // Remove the last digit
        }

        // Return the final reversed number
        return reverseNumber;
    }
}
