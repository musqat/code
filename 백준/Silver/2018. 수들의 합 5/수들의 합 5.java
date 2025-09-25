
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        int count = 0;
        int start = 1, end = 1, sum = 1;

        while (start <= N) {
            if (sum == N){
                count++;
                end++;
                sum += end;
            }else if (sum < N){
                end++;
                sum += end;
            }else {
                sum -= start;
                start++;
            }
        }

        System.out.println(count);
    }
}