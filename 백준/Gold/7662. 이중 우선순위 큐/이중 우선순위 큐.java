import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                String C = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (C.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else if (C.equals("D")){
                    if (map.isEmpty()) {
                        continue;
                    }

                    int target = (num == 1) ? map.lastKey() : map.firstKey();
                    int count = map.get(target);

                    if (count == 1) {
                        map.remove(target);
                    } else {
                        map.put(target, count - 1);
                    }
                }
            }


            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }

    }

}
