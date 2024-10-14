import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                String[] clothes = br.readLine().split(" ");
                String item = clothes[0];
                String type = clothes[1];

                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int result = 1;

            for (int count : map.values()){
                result *= (count + 1);
            }

            result -= 1;

            System.out.println(result);

        }

    }
}
