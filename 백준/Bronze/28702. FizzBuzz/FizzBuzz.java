import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nextNumber = 0;
        boolean flag = false;

        for(int i=0; i<3; i++) {
            String str = br.readLine();
            char c = str.charAt(0);

            if(c != 'F' && c != 'B') {
                nextNumber = Integer.parseInt(str);
                flag = true;
            }

            if(flag) {
                nextNumber++;
            }
        }



        if (nextNumber % 3 == 0 && nextNumber % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (nextNumber % 3 == 0) {
            System.out.println("Fizz");
        } else if (nextNumber % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(nextNumber);
        }


    }

}
