import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (group(br.readLine())) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean group(String str) {
        boolean[] check = new boolean[26];
        char prev = 0;

        for (char curChar : str.toCharArray()){
            if (curChar != prev){
                if (check[curChar - 'a']){
                    return false;
                }
                check[curChar - 'a'] = true;
                prev = curChar;
            }
        }
        return true;

    }
}
