import java.util.Arrays;

public class ClimbStairsRecursive {


    public static int climbStairs(int n) {

        if(n<2)
            return 1;

        return climbStairs(n-2) + climbStairs(n-1);


    }

    public static void main(String[] args) {
        int ans = climbStairs(4);
        System.out.println(ans);
    }
}
