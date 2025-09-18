
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> cnt = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long x = Long.parseLong(br.readLine());
            cnt.put(x, cnt.getOrDefault(x, 0 ) + 1);
        }

        long bestNum = Long.MAX_VALUE;
        int bestCnt = 0;
        for (Map.Entry<Long, Integer> e : cnt.entrySet()){
            long num = e.getKey();
            int c = e.getValue();
            if (c > bestCnt){
                bestCnt = c;
                bestNum = num;
            }else if (c == bestCnt && num < bestNum){
                bestNum = num;
            }
        }

        System.out.println(bestNum);


    }
}