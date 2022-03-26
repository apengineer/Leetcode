package ap.DP;

public class MinCostCLimbingStairsRecursive {

    public static int minCostClimbingStairs(int[] cost) {
        return minCost(cost.length, cost);

    }

    public static int minCost(int index, int[] cost) {
        if (index == 0) return cost[0];
        if(index == 1) return cost[1];

        return Math.min(minCost(index-1, cost), minCost(index-2, cost));

    }

    public static void main(String[] args) {
        int []cost = {10,15,20};
        System.out.println(minCostClimbingStairs(cost));
    }
}
