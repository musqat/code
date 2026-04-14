import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            //마지막 테스트 케이스는 end
            if (s.equals("end")) {
                break;
            }

            if (hasVowel(s) && noTripleConsecutive(s) && noSameConsecutive(s)) {
                System.out.println("<" + s + "> is acceptable.");
            } else {
                System.out.println("<" + s + "> is not acceptable.");
            }


        }

    }


    static boolean hasVowel(String s) {
        String vowels = "aeiou";
        boolean hasVowel = false;
        for (char c : s.toCharArray()) {
            if (vowels.contains(String.valueOf(c))) {
                hasVowel = true;
                break;
            }
        }
        return hasVowel;
    }

    static boolean noTripleConsecutive(String s) {
        for (int i = 0; i < s.length() - 2; i++) {

            if (isVowel(s.charAt(i)) && isVowel(s.charAt(i + 1)) && isVowel(s.charAt(i + 2))){
                return false;
            }
            if (!isVowel(s.charAt(i)) && !isVowel(s.charAt(i + 1)) && !isVowel(s.charAt(i + 2))){
                return false;
            }
        }

        return true;
    }

    static boolean noSameConsecutive(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                char c = s.charAt(i);
                if (c != 'e' && c != 'o') {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isVowel(char c) {
        return "aeiou".contains(String.valueOf(c));
    }

}