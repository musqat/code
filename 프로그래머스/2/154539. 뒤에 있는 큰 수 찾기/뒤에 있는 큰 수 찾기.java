import javax.swing.plaf.InsetsUIResource;
import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= numbers[i]){
                stack.pop();
            }
            
            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            
            stack.push(numbers[i]);
        }


        return answer;
    }
}