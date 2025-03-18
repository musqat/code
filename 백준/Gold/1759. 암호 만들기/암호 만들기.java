import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static javax.swing.text.html.HTML.Attribute.N;

public class Main {
    static int L, C;
    static char[] letters;
    static List<String> result = new ArrayList<>();

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

        dfs(0, 0, "", 0, 0);

        for (String password : result){
            System.out.println(password);
        }
    }

    static void dfs(int idx, int depth, String password, int vowelCount, int consonantCount){
        if (depth == L){
            if (vowelCount >= 1 && consonantCount >= 2){
                result.add(password);
            }
        }
        for (int i = idx; i < C ; i++) {
            char ch = letters[i];
            if (isVowel(ch)){
                dfs(i + 1, depth + 1, password + ch, vowelCount + 1, consonantCount);
            }else {
                dfs(i + 1, depth + 1, password + ch, vowelCount, consonantCount  + 1);
            }

        }
    }
    static boolean isVowel(char ch){
        return "aeiou".indexOf(ch) != -1;
    }


}
