import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int S = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String[] command = br.readLine().split(" ");
            String operation = command[0];

            switch (operation) {
                case "add":
                    int addX = Integer.parseInt(command[1]);
                    S |= (1 << addX); 
                    break;
                case "remove":
                    int removeX = Integer.parseInt(command[1]);
                    S &= ~(1 << removeX); 
                    break;
                case "check":
                    int checkX = Integer.parseInt(command[1]);
                    sb.append((S & (1 << checkX)) != 0 ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    int toggleX = Integer.parseInt(command[1]);
                    S ^= (1 << toggleX); 
                    break;
                case "all":
                    S = (1 << 21) - 1; // S를 {1, 2, ..., 20}으로 설정
                    break;
                case "empty":
                    S = 0; // S를 공집합으로 설정
                    break;
            }
        }

        System.out.print(sb);
        br.close();

    }

}
