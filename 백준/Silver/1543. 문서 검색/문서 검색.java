import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doc = br.readLine();
        String line = br.readLine();

        int count = 0;
        int pos = 0;

        while (true){
            int found = doc.indexOf(line, pos);
            if (found == -1) break;
            count++;
            pos = found + line.length();
        }
        System.out.println(count);
    }
}
