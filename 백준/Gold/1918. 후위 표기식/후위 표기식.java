import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isLetter(c)) {
                sb.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && postFix(stack.peek()) >= postFix(c)) {
                    if (stack.peek() == '(') {
                        break;
                    }
                    sb.append(stack.pop());
                }
                stack.push(c);
            }


        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    static int postFix(char c){
        if (c == '('){
            return 0;
        }
        if (c == '+' || c == '-'){
            return 1;
        }
        if (c == '*' || c == '/'){
            return 2;
        }
        return -1;
    }
}
