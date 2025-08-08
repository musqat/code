import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean isBracket = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                isBracket = true;
                sb.append(c);
            } else if (c == '>') {
                isBracket = false;
                sb.append(c);
            } else if (isBracket) {
                sb.append(c);
            } else {
                if (c == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                } else {
                    stack.push(c);
                }
            }
        }
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
