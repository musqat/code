import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] size;

    static int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    static int union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return size[x];

        if (size[x] < size[y]) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        parent[y] = x;
        size[x] += size[y];
        return size[x];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine());

            parent = new int[2 * F + 5];
            size = new int[2 * F + 5];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            Map<String, Integer> id = new HashMap<>(2 * F * 2);
            int nextId = 0;


            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!id.containsKey(a)) id.put(a, nextId++);
                if (!id.containsKey(b)) id.put(b, nextId++);

                int ra = find(id.get(a));
                int rb = find(id.get(b));
                int mergeSize = union(ra, rb);
                sb.append(mergeSize).append('\n');

            }
        }
        System.out.println(sb);
    }
}