import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int[] arr = new int[26];


        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 97;
            arr[c]++;
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(arr[i] + " ");

        }

    }
}
