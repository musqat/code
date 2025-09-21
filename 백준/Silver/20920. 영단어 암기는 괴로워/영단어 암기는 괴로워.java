
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            if (line.length() >= M) {
                map.put(line, map.getOrDefault(line, 0) + 1);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> {
            int mapA = map.get(a);
            int mapB = map.get(b);
            if (mapA != mapB) return mapB - mapA;
            if (a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append('\n');
        }

        System.out.println(sb);
    }
}