import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        int n = 0;
        long sum = 0;

        while (true){
            sum += n;
            if (sum > S){
                break;
            }
            n++;
        }


        System.out.println(n - 1);


    }

}
