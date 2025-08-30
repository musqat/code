import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");

        long AB = Long.parseLong(line[0] + line[1]);
        long CD = Long.parseLong(line[2] + line[3]);

        System.out.println(AB + CD);
        

    }
}