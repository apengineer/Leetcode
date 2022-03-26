package ap.DP;
import java.util.Arrays;

public class CoinChangeDP {

    public int minCoins(int[]coins, int target, int[]dp) {

        if(target == 0) return 0;

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < coins.length; i++){

            if(target - coins[i] >= 0){
                int subAns = 0;
                if(dp[target-coins[i]] != -1) {
                    subAns = dp[target-coins[i]];
                } else{
                    subAns  = minCoins(coins, target-coins[i], dp);
                    //dp[target-coins[i]] = subAns;
                }
                //ans = Math.min(subAns + 1, ans);
                if(subAns != Integer.MAX_VALUE && subAns + 1 < ans) {
                    ans = subAns + 1;
                }
            }


        }
        if(Integer.MAX_VALUE == ans){
            ans = 0;

        }
        dp[target] = ans;
        return ans;


        /*if(target == 0) return 0;

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i<coins.length; i++) {
            if(target-coins[i] >= 0) {
                int subAns = 0;
                if(dp[target-coins[i]] != -1) {
                    subAns = dp[target-coins[i]];
                } else {
                    subAns = minCoins(coins, target-coins[i], dp);
                }
                if(subAns != Integer.MAX_VALUE &&
                        subAns + 1 < ans) {
                    ans = subAns + 1;
                }
            }
        }
        return dp[target] = ans;*/
    }

    public static void main(String[] args) {
        int[]coins = {1,5,7};
        int target = 18;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0]=0;

        int ans =  new CoinChangeDP().minCoins(coins, target, dp);
        System.out.println(ans);

    }
}
