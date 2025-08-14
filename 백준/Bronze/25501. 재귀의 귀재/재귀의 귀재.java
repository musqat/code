import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            System.out.print(isPalindrome(line) + " ");
            System.out.println(count);
        }
    }

    static int recursion(String s, int l, int r ){
        count++;
        if (l >= r) return 1;
        else if (s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }

    static int isPalindrome(String s){
        count = 0;
        return recursion(s, 0, s.length()- 1 );
    }
}
