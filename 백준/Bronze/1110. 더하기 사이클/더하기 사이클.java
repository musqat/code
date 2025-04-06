import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int m = n;
        int count = 0;

        while (true){
            int tens = m / 10;
            int ones = m % 10;
            int sum = tens + ones;

            m = (ones * 10) + (sum % 10);

            count++;

            if (m == n){
                break;
            }
        }

        System.out.println(count);

    }

}
