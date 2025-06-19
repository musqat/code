import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String target = br.readLine();

        int tlen = target.length();
        char[] tArr = target.toCharArray();

        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            stack.append(s.charAt(i));

            if (stack.length() >= tlen) {
                boolean match = true;
                for (int j = 0; j < tlen; j++) {
                    if (stack.charAt(stack.length() - tlen + j) != tArr[j]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    stack.setLength(stack.length() - tlen);
                }
            }
        }
        System.out.println(stack.length() == 0 ? "FRULA" : stack.toString());

    }
}
