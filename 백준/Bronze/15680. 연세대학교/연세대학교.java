import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = "YONSEI";
        String slogan = "Leading the Way to the Future";
        int N = Integer.parseInt(br.readLine());

        System.out.println(N == 0 ? name : slogan);

    }
}