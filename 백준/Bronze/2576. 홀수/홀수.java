import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result =0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 7; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num % 2 != 0){
                result += num;
                if (num < min){
                    min = num;
                }
            }
        }

        if (result == 0){
            System.out.println(-1);
        }else {
            System.out.println(result + "\n" + min);
        }

    }

}