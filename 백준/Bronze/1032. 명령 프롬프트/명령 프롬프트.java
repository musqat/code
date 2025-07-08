import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] files = new String[N];

        for (int i = 0; i < N; i++) {
            files[i] = br.readLine();
        }

        int len = files[0].length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char c = files[0].charAt(i);
            boolean isSame = true;

            for (int j = 1; j < N; j++) {
                if (files[j].charAt(i) != c){
                    isSame = false;
                    break;
                }

            }
            sb.append(isSame ? c : '?');

        }

        System.out.println(sb);

    }
}
