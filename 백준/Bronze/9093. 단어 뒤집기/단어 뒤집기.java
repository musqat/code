import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0){
            String line = br.readLine();
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(line, " ");
            while (st.hasMoreTokens()) {
                sb.append(new StringBuilder(st.nextToken()).reverse());
                sb.append(' ');
            }
            sb.append("\n");


            System.out.print(sb);

        }

    }
}
