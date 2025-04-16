import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);

        String str = br.readLine();
        str = str.replace("dz=", "!")
                .replace("c=", "!")
                .replace("c-", "!")
                .replace("d-", "!")
                .replace("lj", "!")
                .replace("nj", "!")
                .replace("s=", "!")
                .replace("z=", "!");
        System.out.println(str.length());
    }

}
