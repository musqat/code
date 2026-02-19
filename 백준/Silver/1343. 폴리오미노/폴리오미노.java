import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = checkX(br.readLine());
        System.out.println(s == null ? -1 : s);
    }

    static String checkX(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                sb.append('.');
            }else {
                int count = 0;
                while (i + count < s.length() && s.charAt(i + count) == 'X') {
                    count++;
                }
                i += count - 1;
                if (count % 2 != 0) return null;
                while (count > 0){
                    if (count >= 4){
                        count -= 4;
                        for (int j = 0; j < 4; j++) {
                            sb.append('A');
                        }
                    }else if (count == 2){
                        count -= 2;
                        for (int j = 0; j < 2; j++) {
                            sb.append('B');
                        }
                    }
                }
            }

        }
        return sb.toString();
    }
}