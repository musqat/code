import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        int maxCount = 0 ;

        int[] count = new int[10];

        for (int i = 0; i <n.length() ; i++) {
            int num =  n.charAt(i) - '0';
                count[num]++;
        }

        int sixNine = count[6] + count[9];

        count[6] = count[9] = (sixNine + 1) / 2;

        for (int i = 0; i < 9; i++) {
            if (maxCount < count[i]){
                maxCount = count[i];
            }

        }

        if (maxCount < count[6]){
            maxCount = count[6];
        }
        System.out.println(maxCount);
    }

}
