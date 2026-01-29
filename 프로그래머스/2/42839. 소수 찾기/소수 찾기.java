import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    Set<Integer> list = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;

        String[] num = numbers.split("");
        boolean[] visited = new boolean[num.length];

        backtrack(num, visited, "");

        for (int n : list) {
            if (isPrime(n)) answer++;
        }


        return answer;
    }

    private void backtrack(String[] arr, boolean[] used, String cur) {
        if (!cur.isEmpty()) {
            list.add(Integer.parseInt(cur));
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                used[i] = true;
                backtrack(arr, used, cur + arr[i]);
                used[i] = false;
            }

        }
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }

        return true;
    }
}