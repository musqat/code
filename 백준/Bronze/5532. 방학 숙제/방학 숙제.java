import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine().trim());
        int A = Integer.parseInt(br.readLine().trim());
        int B = Integer.parseInt(br.readLine().trim());
        int C = Integer.parseInt(br.readLine().trim());
        int D = Integer.parseInt(br.readLine().trim());

        int koreanDays = (A + C - 1) / C; // ceil(A/C)
        int mathDays   = (B + D - 1) / D; // ceil(B/D)

        int studyDays = Math.max(koreanDays, mathDays);
        System.out.println(L - studyDays);
    }
}
