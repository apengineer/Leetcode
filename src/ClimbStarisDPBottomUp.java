import java.util.Arrays;

public class ClimbStarisDPBottomUp {
    public static int climbStairs(int n) {

        int[]dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;

        /*//return climbStairs(n-2) + climbStairs(n-1);
        int ans = climbStairs_memo(n, dp);
        return ans;*/

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int ans = climbStairs(4);
        System.out.println(ans);
    }

}
