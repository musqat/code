import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ne = (int) Math.pow(2,n) + 1;
        int nes = (int) Math.pow(ne,2);
        System.out.println(nes);



    }

}
