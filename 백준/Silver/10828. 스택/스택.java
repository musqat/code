import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            String[] order = br.readLine().split(" ");
            if (order[0].equals("push")) {
                st.push(Integer.parseInt(order[1]));
            } else if (order[0].equals("pop")) {
                if (st.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(st.pop());
                }
            } else if (order[0].equals("size")) {
                System.out.println(st.size());
            } else if (order[0].equals("empty")) {
                System.out.println(st.empty() ? 1 : 0);
            } else if (order[0].equals("top")) {
                if (st.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(st.peek());
                }
            }

        }


    }
}
