class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0; // 총 받은 병수

        while (n >= a) {
            int received = (n / a) * b;
            int leftover = n % a;
            
            
            answer += received;
            n = received + leftover;


        }
        return answer;
    }
}