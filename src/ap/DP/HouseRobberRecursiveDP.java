package ap.DP;

import java.util.Arrays;

public class HouseRobberRecursiveDP {
    public static int rob(int[] nums) {

        int[]dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        return rob(nums.length - 1, nums, dp);

    }

    public static int rob(int i, int[]nums, int[]dp) {

       /* if(dp[i] == -1) {
            dp[i] = Math.max(rob(i-1, nums, dp), nums[i] + rob(i -2, nums, dp));
        }
        return dp[i];*/

        for(i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], (nums[i] + dp[i-2]));

        }
        return dp[nums.length - 1];
    }



    public static void main(String[] args) {
        int[]nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }


}
