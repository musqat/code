import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            String vps = br.readLine();
            System.out.println(isVPs(vps) ? "YES" : "NO");

        }

    }

    public static boolean isVPs(String vps){
        Stack<String> st = new Stack<>();
        String[] arr = vps.split("");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("(")){
                st.push("(");
            } else if (arr[i].equals(")")) {
                if (st.isEmpty()) {
                    return false;
                }
                st.pop();

            }
        }
        return st.isEmpty();
    }

}
