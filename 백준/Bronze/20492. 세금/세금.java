import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());

        long case1 = N * 78 / 100;     
        long case2 = N * 956 / 1000;  

        System.out.println(case1 + " " + case2);

    }
}