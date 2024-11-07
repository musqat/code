import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int left = 0;
        int right = arr.length - 1;


        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                right = left + query[i];
            } else {
                left = left + query[i];
            }
        }

        return Arrays.copyOfRange(arr, left, right + 1);
    }
}