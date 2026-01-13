class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;
        for (int i = 0; i < len-2; i++) {
            for (int j = i + 1; j < len-1; j++) {
                for (int k = j + 1; k < len; k++) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (isPrime(sum)) {
                        answer++;
                    }
                }
            }

        }


        return answer;
    }

    public boolean isPrime(int x) {
        if (x < 2) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false;


        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }

        return true;

    }
}