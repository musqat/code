import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final boolean[] IS_VOWEL = new boolean[26];

    static {
        IS_VOWEL['A' - 'A'] = true;
        IS_VOWEL['E' - 'A'] = true;
        IS_VOWEL['I' - 'A'] = true;
        IS_VOWEL['O' - 'A'] = true;
        IS_VOWEL['U' - 'A'] = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();

            if (line.equals("#")) {
                break;
            }

            int count = 0;
            for (int i = 0; i < line.length(); i++) {
                if (isVowel(line.charAt(i))) count++;

            }
            System.out.println(count);
        }

    }

    static boolean isVowel(char ch) {
        char u = Character.toUpperCase(ch);
        int idx = u - 'A';
        return (idx >= 0 && idx < 26) && IS_VOWEL[idx];
    }

}
