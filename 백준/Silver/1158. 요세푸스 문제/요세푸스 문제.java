import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        sb.append('<');
        while (!list.isEmpty()){
            for (int i = 0; i < K; i++) {
                if (i == K-1){
                    if (list.size() == 1){
                        sb.append(list.remove());
                    }else {
                        sb.append(list.remove()).append(", ");
                    }
                }else {
                    list.add(list.remove());
                }
            }
        }
        sb.append('>');
        System.out.println(sb);
    }

}
