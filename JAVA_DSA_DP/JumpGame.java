package JAVA_DSA_DP;
// To solution to jump the index to reach last index
// each index value represents max jump means you jump from 1 to max value
// consider an dp array of length n with values of true or false to reach end or not
// we are traversing from last to first considering last value in dp array is true as it will reach
class JumpGame {
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n-1] = true; // last value always false;
        // Iterate from last
        for(int i = n-2; i >=0; i--){
            for(int j = 1; j <= nums[i] && dp[i]== false && i + j < n; j++){
                //i + j < n imp condition to check if it greather than n it is false
                dp[i] = dp[i+j];
            }
        }

        return dp[0]; // return first as it reached from last to first
    }
}

