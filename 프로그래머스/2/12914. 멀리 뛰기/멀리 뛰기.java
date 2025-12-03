class Solution {
    static long[] memo = new long[2001]; // n ≤ 2000

    public long solution(int n) {
        return stair(n) % 1234567;
    }

    static long stair(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (memo[n] != 0) return memo[n];
        
        memo[n] = (stair(n - 1) + stair(n - 2)) % 1234567;

        return memo[n];
    }
}