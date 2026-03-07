package DSA.Bitwise.Problems;

class Sum2Integers {
    public int getSum(int a, int b) {
        // Log: Starting the process to calculate sum of a and b without + and - operators.
        System.out.println("Initial values: a = " + a + ", b = " + b);

        // Loop until there is no carry left
        while (b != 0) {
            // Step 1: Calculate carry using bitwise AND and left shift
            int carry = (a & b) << 1;
            System.out.println("Carry calculated: " + carry);

            // Step 2: Calculate sum without carry using XOR
            int sumWithoutCarry = a ^ b;
            System.out.println("Sum without carry: " + sumWithoutCarry);

            // Step 3: Update a and b for the next iteration
            b = carry;
            a = sumWithoutCarry;
            System.out.println("Updated values: a = " + a + ", b = " + b);
        }

        // Log: Final result after carry is 0
        System.out.println("Final result: " + a);
        return a;
    }
}