class Solution {
    public int solution(int n) {
        if (n <= 1) return n;
        
        int prev2 = 0;
        int prev1 = 1;
        int cur = 0;

        for (int i = 2; i <= n; i++) {
            cur = (prev1 + prev2) % 1234567;
            prev2 = prev1;
            prev1 = cur;
        }
        
        return cur;
    }
}