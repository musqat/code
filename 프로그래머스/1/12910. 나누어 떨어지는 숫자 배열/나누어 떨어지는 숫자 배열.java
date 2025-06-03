import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public Integer[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }


        if (list.isEmpty()){
            list.add(-1);
        }
        return list.toArray(new Integer[0]);
    }
}