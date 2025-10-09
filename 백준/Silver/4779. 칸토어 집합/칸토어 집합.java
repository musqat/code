import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null){
            line = line.trim();
            if (line.isEmpty()) continue;
            int N = Integer.parseInt(line);

            int len = 1;

            for (int i = 0; i < N; i++) {
                len *= 3;
            }

            char[] arr = new char[len];
            Arrays.fill(arr, '-');

            carve(arr, 0, len);
            sb.append(arr).append('\n');
        }

        System.out.print(sb);
    }

    static void carve(char[] arr, int start, int len){
        if (len == 1) return;
        int third = len / 3;

        for (int i = start + third; i < start + 2 * third; i++) {
            arr[i] = ' ';
        }

        carve(arr, start, third);
        carve(arr, start + 2 * third, third);
    }
}