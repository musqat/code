import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
                List<Integer> twoIndices = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                twoIndices.add(i);
            }
        }
        
        if (twoIndices.isEmpty()) {
            return new int[] {-1};
        }
        
        int start = twoIndices.get(0);
        int end = twoIndices.get(twoIndices.size() - 1);
        
        int[] result = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            result[i - start] = arr[i];
        }
        
        return result;

    }
}