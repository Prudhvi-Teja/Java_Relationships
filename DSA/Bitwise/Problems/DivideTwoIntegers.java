package DSA.Bitwise.Problems;

class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        // Step 1: Handle edge case for overflow
        // When dividing Integer.MIN_VALUE (-2^31) by -1, the result exceeds Integer.MAX_VALUE (2^31 - 1).
        if (dividend == -(1 << 31) && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Step 2: Initialize variables
        int quotient = 0; // Stores the final result
        // Determine if the result should be positive using sign logic
        boolean isPositive = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0);
        
        // Step 3: Handle case where dividend equals divisor
        // If dividend == divisor, the quotient is either 1 or -1 depending on the sign
        if (dividend == divisor) {
            return isPositive ? 1 : -1;
        }
        
        // Step 4: Convert dividend and divisor to absolute values
        // Use long to avoid overflow during operations
        long divid = Math.abs((long) dividend);
        long divis = Math.abs((long) divisor);
        
        // Step 5: Perform division using bit manipulation
        // Repeat the process while divisor can still divide the dividend
        while (divis <= divid) {
            int count = 0; // Tracks how many times divisor can be left-shifted
            // Find the maximum shift count where (divisor << count) <= dividend
            while ((divis << count) <= divid) {
                count++;
            }
            // Add the corresponding power of 2 to the quotient
            quotient += (1 << (count - 1));
            // Reduce the dividend by the shifted divisor value
            divid -= (divis << (count - 1));
        }
        
        // Step 6: Apply the sign to the quotient
        // If the result is positive, return quotient; otherwise, return -quotient
        return isPositive ? quotient : -quotient;
    }
}