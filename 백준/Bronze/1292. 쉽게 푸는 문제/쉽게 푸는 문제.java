import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        List<Integer> arr = new ArrayList<>();

        int num = 1;
        while (arr.size() < B){
            for (int i = 0; i < num && arr.size() < B; i++) {
                arr.add(num);
            }
            num++;
        }

        int sum = 0;
        for (int i = A-1; i < B; i++) {
            sum += arr.get(i);
        }

        System.out.println(sum);

    }
}
