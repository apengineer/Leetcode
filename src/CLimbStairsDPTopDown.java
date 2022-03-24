import java.util.Arrays;

public class CLimbStairsDPTopDown {
    public static int climbStairs(int n) {

        int[]dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;

        int ans = climbStairs_memo(n, dp);
        return ans;

    }

    public static int climbStairs_memo(int n, int[]dp) {

        if( n >= 2) {
            if(dp[n] != -1) {

            } else{
                if(dp[n-1] != -1 && dp[n-2] != -1) {
                    dp[n] = dp[n-1] + dp[n-2];
                }else{
                    dp[n-1] = climbStairs_memo(n-1, dp);
                    dp[n-2] = climbStairs_memo(n-2, dp);
                    dp[n] = dp[n-1] + dp[n-2] ;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int ans = climbStairs(8);
        System.out.println(ans);
    }
}
