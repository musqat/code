import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public String[] solution(String[] strings, int n) {
          Arrays.sort(strings, Comparator.comparingInt((String a) -> a.charAt(n)).thenComparing(a -> a));

         return strings;
    }
}