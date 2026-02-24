import java.io.*;
import java.util.*;

public class Main {
    static long[] reducedNumber = new long[1024];
    static int size = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        makeReduceNumber();
        if (N >= size){
            System.out.println(-1);
        }else {
            System.out.println(reducedNumber[N]);
        }

    }


    static void makeReduceNumber() {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < 1024; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= 9; j++) {
                if ((i & (1 << j)) != 0) {
                    list.add(j);
                }
            }
            Collections.sort(list, Collections.reverseOrder());
            long num = 0;
            for (int d : list) {
                num = num * 10 + d;
            }
            set.add(num);
        }
        size = set.size();
        int idx =0;
        for (long n : set){
            reducedNumber[idx++] = n;
        }

    }


}