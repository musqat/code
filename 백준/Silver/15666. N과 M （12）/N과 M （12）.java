import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] comArray  = new int[M];

        Arrays.sort(arr);
        combination(0,0, comArray);
        System.out.println(sb);

    }

    private static void combination(int cnt, int start, int[] comArray){
        if (cnt == M){
            for (int i = 0; i < cnt; i++) {
                sb.append(comArray[i]).append(' ');
            }
            sb.append("\n");
            return;
        }
        int before = Integer.MIN_VALUE;
        for (int i = start; i < N; i++) {
            if (before == arr[i]){
                continue;
            }
            comArray[cnt] = arr[i];
            combination(cnt + 1, i, comArray);
            before = arr[i];
        }
    }
}
