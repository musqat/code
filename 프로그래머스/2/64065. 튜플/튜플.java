import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);

        String[] arr = s.split("},\\{");

        Arrays.sort(arr, Comparator.comparingInt(String::length));

        Set<Integer> set = new HashSet<>();
        int[] answer = new int[arr.length];
        int idx = 0;
        
        for (String str : arr){
            for (String num : str.split(",")){
                int n = Integer.parseInt(num);
                if (!set.contains(n)){
                    set.add(n);
                    answer[idx++] = n;
                    break;
                }
            }
        }

        return answer;
    }
}