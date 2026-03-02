package JAVA_DSA_DP;

import java.util.LinkedList;
import java.util.Queue;

//Key Concepts Covered in Comments:
// Matrix Initialization:

// Explain dimensions and why the output matrix (ans) is used to store distances.
// Initial values for ans clarify the BFS setup.
// Queue for BFS:

// Why BFS is used for shortest path problems.
// Role of the queue in processing cells and their neighbors.
// Distance Calculation:

// How distances are updated using the BFS traversal.
// When and why neighbors are added to the queue.
// Boundary and Validity Check:

// Role of the isValid function in ensuring matrix bounds and valid candidates.
// Efficiency:

// BFS ensures every cell is processed only once, making the approach 
// O(m×n)
// O(m×n).

class Matrix_01 {
    public int[][] updateMatrix(int[][] mat) {
        // Step 1: Get the dimensions of the matrix
        int m = mat.length;
        int n = mat[0].length;

        // Step 2: Create an output matrix to store distances
        int[][] ans = new int[m][n];
        
        // Step 3: Initialize a queue for BFS traversal
        // The queue will store the positions of elements in the format "row-col"
        Queue<String> queue = new LinkedList<>();

        // Step 4: Initialize the output matrix and populate the queue
        // If the cell is 0, set its distance to 0 and add its position to the queue
        // If the cell is 1, set its distance to a large value (m * n)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    ans[i][j] = m * n; // Maximum distance initially
                } else {
                    ans[i][j] = 0; // Distance is 0 for cells with 0
                    queue.add(i + "-" + j); // Add position of 0 to the queue
                }
            }
        }

        // Step 5: Perform BFS to calculate the distance for each cell
        while (!queue.isEmpty()) {
            // Get the current cell position from the queue
            String dir = queue.poll();
            int row = Integer.parseInt(dir.split("-")[0]);
            int col = Integer.parseInt(dir.split("-")[1]);

            // Calculate the new distance for neighboring cells
            int newDistance = ans[row][col] + 1;

            // Step 6: Update distances for valid neighbors
            // Check the cell below
            if (isValid(row + 1, col, mat) && ans[row + 1][col] > newDistance) {
                ans[row + 1][col] = newDistance; // Update distance
                queue.add((row + 1) + "-" + col); // Add neighbor to the queue
            }
            // Check the cell above
            if (isValid(row - 1, col, mat) && ans[row - 1][col] > newDistance) {
                ans[row - 1][col] = newDistance; // Update distance
                queue.add((row - 1) + "-" + col); // Add neighbor to the queue
            }
            // Check the cell to the right
            if (isValid(row, col + 1, mat) && ans[row][col + 1] > newDistance) {
                ans[row][col + 1] = newDistance; // Update distance
                queue.add(row + "-" + (col + 1)); // Add neighbor to the queue
            }
            // Check the cell to the left
            if (isValid(row, col - 1, mat) && ans[row][col - 1] > newDistance) {
                ans[row][col - 1] = newDistance; // Update distance
                queue.add(row + "-" + (col - 1)); // Add neighbor to the queue
            }
        }

        // Step 7: Return the final matrix with distances
        return ans;
    }

    // Helper function to check if a cell is valid for BFS traversal
    private boolean isValid(int i, int j, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // Check if the cell is within bounds
        if (i < 0 || i >= m) return false;
        if (j < 0 || j >= n) return false;

        // Check if the cell is a valid candidate (must be 1)
        if (mat[i][j] != 1) return false;

        return true;
    }
}