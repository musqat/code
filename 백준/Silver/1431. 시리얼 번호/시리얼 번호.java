import java.io.*;
import java.util.*;

public class Main {
    static class Serial implements Comparable<Serial> {
        String val;

        Serial(String val) { this.val = val; }

        int digitSum(String s){
            int sum = 0;
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    sum += c - '0';
                }
            }
            return sum;
        }

        @Override
        public int compareTo(Serial o) {
            if (this.val.length() != o.val.length()) {
                return this.val.length() - o.val.length();
            }
            if (digitSum(this.val) != digitSum(o.val)) {
                return  Integer.compare(digitSum(this.val), digitSum(o.val));
            }
                return this.val.compareTo(o.val);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Serial[] arr = new Serial[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new Serial(br.readLine());
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i].val);

        }

    }
}