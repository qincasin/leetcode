package learning;

/**
 * <Description>
 *
 * @author qinjiaxing on 2023/4/5
 * @author <others>
 */
public class _01 {
    /**
     * 0 1 2 3 4 5
     * 0 1 1 2 3 5
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(fib2(40));
    }

    public static int fib1(int n) {
        if (n < 2) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    public static int fib2(int n) {
        if (n < 2) {
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    public static int fib3(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
