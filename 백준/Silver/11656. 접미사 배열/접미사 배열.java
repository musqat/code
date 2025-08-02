import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int len = line.length();
        String[] arr = new String[len];


        for (int i = 0; i < len; i++) {
            arr[i] = line.substring(i, len);
        }
        Arrays.sort(arr);
        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);

        }
    }

}

