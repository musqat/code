import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int count = 0;
        int patternCount = 0;

        for (int i = 1; i < M-1; i++) {
            if (S.charAt(i) == 'O' && S.charAt(i - 1) == 'I' && S.charAt(i + 1) == 'I') {
                patternCount++;
                if (patternCount == N){
                    count++;
                    patternCount--;
                }
                i++;
            }else {
                patternCount = 0;
            }

        }
        System.out.println(count);
    }

}