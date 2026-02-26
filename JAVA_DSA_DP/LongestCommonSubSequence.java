package JAVA_DSA_DP;

// Problem: Longest Common Subsequence
// Approach: Recursion with Memoization (Top-Down Dynamic Programming)
// Goal: Find the length of the longest subsequence that is common to both strings text1 and text2.

// Explanation:
// A subsequence is a sequence derived from another sequence by deleting some or no elements 
// without changing the order of the remaining elements.
// For example, "ace" is a subsequence of "abcde".
// The problem is to find the longest subsequence common to both strings using recursion and memoization.

// TC  => O(NM)


import java.util.Arrays;

class LongestCommonSubSequence {
    // 2D memoization array to store results of subproblems
    private int[][] lcs;

    public int longestCommonSubsequence(String text1, String text2) {
        // Step 1: Get the lengths of both strings
        int n = text1.length(); // Length of text1
        int m = text2.length(); // Length of text2

        // Step 2: Initialize the memoization array with -1
        // lcs[i][j] will store the result for the subproblem considering text1[0..i] and text2[0..j]
        this.lcs = new int[n][m];
        for (int[] row : lcs)
            Arrays.fill(row, -1); // Fill with -1 to indicate uncomputed values

        // Step 3: Start the recursion from the last characters of both strings
        return dpMemor(n - 1, m - 1, text1, text2);
    }

    // Recursive function with memoization to compute LCS
    private int dpMemor(int i, int j, String a, String b) {
        // Base Case: If either string is fully processed, no common subsequence is possible
        if (i == -1 || j == -1) return 0;

        // Step 4: Check if the result is already computed for this subproblem
        if (lcs[i][j] == -1) {
            // Step 5: If characters match, add 1 to the result of the remaining substrings
            if (a.charAt(i) == b.charAt(j)) {
                
                lcs[i][j] = dpMemor(i - 1, j - 1, a, b) + 1;
            } else {
                // Step 6: If characters don't match, take the maximum of:
                // (1) Skipping the current character of text1
                // (2) Skipping the current character of text2
                lcs[i][j] = Math.max(dpMemor(i - 1, j, a, b), dpMemor(i, j - 1, a, b));
            }
        }
        // Return the computed result for this subproblem
        return lcs[i][j];
    }
}