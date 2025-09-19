
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String line = br.readLine();

            if (line.equals("END")) break;
            StringBuilder sb = new StringBuilder(line);

            System.out.println(sb.reverse());
        }
    }
}