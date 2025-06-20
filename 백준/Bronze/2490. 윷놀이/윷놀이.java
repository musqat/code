import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int i = 0; i < 3; i++) {
            int result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                result += Integer.parseInt(st.nextToken());
            }
            if (result == 0){
                System.out.println("D");
            }else if (result == 1){
                System.out.println("C");
            } else if (result == 2) {
                System.out.println("B");
            }else if (result == 3){
                System.out.println("A");
            }else {
                System.out.println("E");
            }

        }
    }
}
