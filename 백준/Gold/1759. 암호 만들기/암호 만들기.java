import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static javax.swing.text.html.HTML.Attribute.N;

public class Main {
    static int L, C;
    static char[] letters;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        letters = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            letters[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(letters);
        char[] password = new char[L];
        dfs(0, 0, password, 0, 0);

    }

    static void dfs(int idx, int depth, char[] password, int vowelCount, int consonantCount){
        if (depth == L){
            if (vowelCount >= 1 && consonantCount >= 2){
                System.out.println(new String(password));
            }
            return;
        }

        for (int i = idx; i < C ; i++) {
            char ch = letters[i];
            password[depth] = ch;
            if (isVowel(ch)){
                dfs(i + 1, depth + 1, password, vowelCount + 1, consonantCount);
            }else {
                dfs(i + 1, depth + 1, password, vowelCount, consonantCount  + 1);
            }

        }
    }
    static boolean isVowel(char ch){
        return "aeiou".indexOf(ch) != -1;
    }


}
