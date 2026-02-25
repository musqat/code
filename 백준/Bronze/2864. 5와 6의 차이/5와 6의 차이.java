import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A =  st.nextToken();
        String B =  st.nextToken();

        int A5 = Integer.parseInt(A.replace('6','5'));
        int A6 = Integer.parseInt(A.replace('5','6'));
        int B5 = Integer.parseInt(B.replace('6','5'));
        int B6 = Integer.parseInt(B.replace('5','6'));



        System.out.print(A5 + B5 + " ");
        System.out.print(A6 + B6);


    }


}