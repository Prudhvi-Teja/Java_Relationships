Dynamic Programming 

Basically, to solve the problem we are going to combine the solution of sub problems

overlapping we are trying to solve same sub problem again and again 

<!-- Approach to DP : -->

Memorization : When you compute something for the first time, you store it so that it can be reused and later on

Compute subproblems in correct order


Top-Down and Bottom-Up approaches in the context of solving Dynamic Programming problems, particularly the Longest Common Subsequence problem.

1. Top-Down Approach (Your Code Uses This):
Definition: A Top-Down approach involves solving the problem recursively, breaking it into subproblems, and using memoization to store the results of already solved subproblems. This avoids redundant calculations and improves efficiency.
Process:
Start from the end of the strings and recursively solve smaller subproblems (e.g., comparing subsequences from the beginning up to indices i and j).
Use a memoization table (lcs[i][j]) to store the results of subproblems so they can be reused.
Base Cases:
If either string is fully processed (i.e., i == -1 || j == -1), return 0.
Recursive Relation:
If characters match (text1[i] == text2[j]), include them in the subsequence and move to the next pair: 

lcs[i][j]=max(lcs[i−1][j],lcs[i][j−1])


2. Bottom-Up Approach:
Definition: A Bottom-Up approach involves solving the problem iteratively using a DP table. It starts from the smallest subproblems (base cases) and builds up to solve the entire problem.
Process:
Create a DP table (dp[i][j]) where dp[i][j] represents the LCS length for text1[0..i] and text2[0..j].
Base Cases:
Initialize the first row and column to 0 because if one string is empty, the LCS length is 0.
Iterative Relation:
Loop through both strings and fill the table:
If characters match (text1[i] == text2[j]): 

dp[i][j]=max(dp[i−1][j],dp[i][j−1])


Final Result: The value at dp[n][m] (bottom-right corner) gives the LCS length.
Key Differences:
Feature	Top-Down Approach	Bottom-Up Approach
Methodology	Recursive with Memoization	Iterative with DP Table
Direction	Start from the end and solve backward	Start from the beginning and solve forward
Space Complexity	Includes recursion stack + memoization	Requires only the DP table
Ease of Implementation	Often easier to implement recursively	Requires more careful table initialization
Performance	Both are 
O(n×m)

O(n×m) but Bottom-Up avoids recursion overhead	


IMP : Whenever you are given a problem of subsets mostly it's a DP problem







