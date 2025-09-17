
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'A']++;

        int oddCount = 0;
        int oddIndex = -1;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1){
                oddCount++;
                oddIndex = i;
            }
        }

        if (oddCount >= 2){
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder front = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            int half = cnt[i] / 2;
            for (int j = 0; j < half; j++) {
                front.append((char)('A' + i));
            }
        }

        String center = "";
        if (oddIndex != -1) center = String.valueOf((char) ('A' + oddIndex));

        StringBuilder result = new StringBuilder();
        result.append(front);
        result.append(center);
        result.append(front.reverse());

        System.out.println(result);


    }
}