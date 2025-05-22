import java.util.Arrays;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] sArr = s.split(" ");
        int sLen = sArr.length; 
        int[] arr = new int[sLen];

        for (int i = 0; i < sLen; i++) {
            arr[i] = Integer.parseInt(sArr[i]);
        }

        Arrays.sort(arr);
        
        sb.append(arr[0]).append(" ").append(arr[sLen-1]);
        
        
        
        return sb.toString();
    }
}