
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T--> 0){
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }

            Arrays.sort(arr);

            boolean ok = true;
            for (int i = 0; i + 1 < n; i++) {
                if (arr[i+1].startsWith(arr[i])){
                    ok = false;
                    break;
                }
            }

            sb.append(ok ? "YES\n" : "NO\n");
        }


        System.out.println(sb);

    }
}