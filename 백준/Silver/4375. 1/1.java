import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        String s;
        StringBuilder answer = new StringBuilder();
        
        while ((s=br.readLine()) != null) {
            int n = Integer.parseInt(s);
            int number = 1;
            int len = 1;
            while ((number = number % n) != 0){
                len++;
                number = (number * 10 + 1);
            }
            answer.append(len).append('\n');
        }
        System.out.println(answer);
    }

}
