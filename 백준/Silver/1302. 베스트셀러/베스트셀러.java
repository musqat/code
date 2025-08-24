import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> tm = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            tm.put(line, tm.getOrDefault(line, 0) + 1);
        }

        String max = "";
        int maxCount = 0;

        for (String line : tm.keySet()){
            if (tm.get(line) > maxCount){
                maxCount = tm.get(line);
                max = line;
            }
        }

        System.out.println(max);
    }

}