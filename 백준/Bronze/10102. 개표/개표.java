import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int a = 0;
        int b = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                a++;
            }else if (s.charAt(i) == 'B') {
                b++;
            }
        }

        if (a > b){
            System.out.println("A");
        } else if (a < b) {
            System.out.println("B");
        }else {
            System.out.println("Tie");
        }
    }
}
