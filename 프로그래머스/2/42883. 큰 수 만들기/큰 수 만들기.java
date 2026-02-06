import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < number.length(); i++) {
            int n = number.charAt(i) - '0';

            while (!stack.isEmpty() && stack.peek() < n && count < k){
                stack.pop();
                count++;
            }
            stack.push(n);
        }
        
        int rest = k - count;
        if (rest > 0){
            for (int i = 0; i < rest; i++) {
                stack.pop();
            }
        }
    
        for (int num : stack){
            sb.append(num);
        }
        

        return sb.toString();
    }
}