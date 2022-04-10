package ap.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapSackDPPractice {

    public static int[][] knapsack(int[]values, int[]weights, int sack) {
        int[][]dp = new int[values.length + 1][sack + 1];
        Arrays.fill(dp[0], 0);
        for(int i = 1; i <= values.length; i++) {
            int index = i-1;
            for(int j = 0; j <= sack ;  j++) {
                if(weights[index] <= j) {
                    // j - weights[i]                                               --> weight remaining in sack after adding an item
                    dp[i][j] = Math.max(dp[i-1][j], (values[index] + dp[i-1][j - weights[index]]));
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(Arrays.deepToString(dp).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));

        return dp;
    }

    public static int[] maximisingElements(int[][]dp, int[] values, int[] weights){

            /* look at last element. If that same as element above, go above
            else pick the element. Subtract sack weight(j) - element weight (w) = x. Go one row above, to x cols

             */

        List<Integer> ret = new ArrayList<>();

        //int i = values.length - 1;
        int i = dp.length - 1;
        int j = dp[0].length - 1;


        while(i > 0 && j > 0) {
            if (dp[i][j] == dp[i-1][j]) {
                i = i - 1;
            } else{
                ret.add(values[i-1]);
                j = j - weights[i-1];
                i = i - 1;
            }
        }

        int[] arr = ret.stream().mapToInt(k -> k).toArray();
        return arr;

    }



    public static void main(String[] args) {
       /* int[] values = {0,2 , 2,4,5};
        int[] weights = {0, 3, 1, 3, 4};
        int sack = 7; */

        int[] values = {2, 1,3};
        int[] weights = { 1,3,4};
        int sack = 7;

        int[][] dp = knapsack(values, weights, sack);
        int[] res= maximisingElements(dp,values, weights);
        System.out.println(Arrays.toString(res));
    }
}
