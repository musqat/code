import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] times = {300, 60, 10};
        int[] result = new int[3];

        for (int i = 0; i < 3; i++) {
            result[i] = T / times[i];
            T %= times[i];
        }

        if (T == 0){
            System.out.println(result[0] + " " + result[1] + " " + result[2]);
        }else {
            System.out.println("-1");
        }

    }

}
