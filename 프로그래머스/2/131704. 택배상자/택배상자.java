import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int idx = 1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < order.length; i++) {
            while (idx <= order.length && idx < order[i]){
                stack.push(idx);
                idx++;
            }
            if (idx == order[i]){ // 메인 벨트
                answer++;
                idx++;
            }else if (!stack.isEmpty() && stack.peek() == order[i]){ // 스택 top
                answer++;
                stack.pop();
            }else {
                break;
            }
            
        }
        
        
        return answer;
    }
}