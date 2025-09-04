import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] alphabet = new int[26];
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            int c = arr[i].charAt(0) - 'a';
            alphabet[c]++;
        }

        StringBuilder sb = new StringBuilder();
        boolean over5 = false;
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] >= 5){
                over5 = true;
                sb.append((char)(i + 'a'));            }
        }

        System.out.println(over5 ? sb : "PREDAJA");
    }
}