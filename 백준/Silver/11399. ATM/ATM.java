import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] Pi = new int[N];
        for (int i = 0; i < N; i++) {
            Pi[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(Pi);

        int total = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += Pi[i];
            total += sum;
        }


        System.out.println(total);



    }


}