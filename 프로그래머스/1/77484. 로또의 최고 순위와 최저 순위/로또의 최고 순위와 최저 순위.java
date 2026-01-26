import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int count = 0;
        int zeroCount = 0;

        Set<Integer> winSet = new HashSet<>();

        for (int num : win_nums){
            winSet.add(num);
        }

        for (int num : lottos){
            if (num == 0){
                zeroCount++;
            }else if (winSet.contains(num)){
                count++;
            }
        }

        answer[0] = rank[zeroCount + count];
        answer[1] = rank[count];




        return answer;
    }
}