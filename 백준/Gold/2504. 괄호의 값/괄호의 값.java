import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        Stack<Integer> values = new Stack<>();

        int result = 0;
        int temp = 1;

        boolean isValid = true;


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch (c){
                case '(':
                    temp *= 2;
                    stack.push(c);
                    break;
                case '[':
                    temp *= 3;
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '('){
                        isValid = false;
                        break;
                    }
                    if (s.charAt(i - 1) == '('){
                        result += temp;
                    }
                    stack.pop();
                    temp /=2;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '['){
                        isValid = false;
                        break;
                    }
                    if (s.charAt(i - 1) == '['){
                        result += temp;
                    }
                    stack.pop();
                    temp /= 3;
                    break;

            }
            if (!isValid) break;

        }

        if (!isValid || !stack.isEmpty()){
            System.out.println(0);
        }else {
            System.out.println(result);
        }
    }
}
