
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();

        int count = 0;
        while (N--> 0){
            String line = br.readLine();
            if (line.equals("ENTER")) {
                set.clear();
                continue;
            }

            if (!set.contains(line)){
                count++;
                set.add(line);
            }

        }

        System.out.println(count);


    }
}