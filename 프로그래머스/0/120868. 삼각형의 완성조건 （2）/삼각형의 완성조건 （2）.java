import java.util.Arrays;

class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
        int a = sides[0];
        int b = sides[1];
        int min = b - a + 1;
        int max = a + b - 1;

        int answer = max - min + 1;
        return answer;
    }
}