import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        int[] countA = new int[26];
        int[] countB = new int[26];

        for (char c : A.toCharArray()) countA[c - 'a']++;
        for (char c : B.toCharArray()) countB[c - 'a']++;

        int answer = 0;
        for (int i = 0; i < 26; i++) {
            answer += Math.abs(countA[i] - countB[i]);
        }


        System.out.println(answer);


    }
}