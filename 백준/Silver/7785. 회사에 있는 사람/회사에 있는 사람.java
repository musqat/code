import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        Map<String, Boolean> map = new HashMap<>();



        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            if (b.equals("enter")) {
                map.put(a, true);
            } else if (b.equals("leave")) {
                map.remove(a);
            }
        }

        List<String> result = new ArrayList<>(map.keySet());
        Collections.sort(result, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String a : result) {
            sb.append(a).append("\n");

        }

        System.out.println(sb);

    }


}