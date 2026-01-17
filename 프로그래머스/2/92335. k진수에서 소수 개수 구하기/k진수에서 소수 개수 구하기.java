class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String[] num = Integer.toString(n, k).split("0");


        for (String s : num) {
            if (s.isEmpty()) continue;
            if (isPrime(s)) {
                answer++;
            }

        }

        return answer;
    }

    private boolean isPrime(String num) {
        if (num.isEmpty()) return false;
        long n = Long.parseLong(num);

        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for(long i = 3; i <= Math.sqrt(n); i += 2){
            if (n % i ==0) return false;
        }

        return true;
    }
}