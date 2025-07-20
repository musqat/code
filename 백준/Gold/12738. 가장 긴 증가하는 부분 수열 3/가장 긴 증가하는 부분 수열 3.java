import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        long[] arr = new long[A];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Long> lis = new ArrayList<>();
        for (long num : arr){
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0){
                pos = -(pos + 1);
            }

            if (pos == lis.size()){
                lis.add(num);
            }else {
                lis.set(pos, num);
            }
        }

        System.out.println(lis.size());
    }
}
