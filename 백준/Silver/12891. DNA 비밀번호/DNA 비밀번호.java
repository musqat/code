import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] check = new int[4]; // A,C,G,T
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); // 문자 전체길이
        int P = Integer.parseInt(st.nextToken()); // 부분 길이

        String str = br.readLine(); // 문자열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[4]; // check이랑 비교용;
        for (int i = 0; i < P; i++) {
            count[getIdx(str.charAt(i))]++;
        }


        int left = 0;
        while (left + P <= S) {
            if (left > 0){
                count[getIdx(str.charAt(left - 1))]--;
                count[getIdx(str.charAt(left + P - 1))]++;
            }
            if (isValid(count, check)) result++;
            left++;
        }

        System.out.println(result);

    }

    private static boolean isValid(int[] count, int[] check){
        for (int i = 0; i < 4; i++) {
            if (count[i] >= check[i]){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }


    private static int getIdx(char c) {
        if (c == 'A') return 0;
        if (c == 'C') return 1;
        if (c == 'G') return 2;
        return 3; // T
    }

}