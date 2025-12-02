import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        String s = Integer.toBinaryString(n);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1'){
                ans++;
            }

        }

        return ans;
    }
}