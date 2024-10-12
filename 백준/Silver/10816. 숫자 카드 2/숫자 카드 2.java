import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> cardMap = new HashMap<>();
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(input[i]);
            cardMap.put(num, cardMap.getOrDefault(num, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int query = Integer.parseInt(input2[i]);
            sb.append(cardMap.getOrDefault(query, 0)).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
