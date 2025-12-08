import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();

        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            deque.addLast(c);
        }


        for (int i = 0; i < len; i++) {
            if (isValid(deque)) {
                answer++;
            }
            deque.addLast(deque.removeFirst());
        }


        return answer;
    }


    static boolean isValid(Deque<Character> deque) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : deque) {
            if (c == '(' || c == '{' ||c == '['  ){
                stack.push(c);
            }else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }

        return stack.isEmpty();
    }
}