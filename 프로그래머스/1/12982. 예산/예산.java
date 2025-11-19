import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int sum = 0;
        int count = 0;


        for (int price : d){
            if (sum + price > budget) break;
            sum += price;
            count++;
        }
        
        return count;
    }
}