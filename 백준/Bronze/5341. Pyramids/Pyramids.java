import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (true){
            int N = sc.nextInt();
            if (N == 0){
                break;
            }
            int sum = (N * (N + 1) / 2);
            System.out.println(sum);

        }
    }

}
