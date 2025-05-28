import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double result = 0;
        double gradeSum = 0;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            double n = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (grade.equals("P")) continue;

            result += cal(n, grade);
            gradeSum += n;

        }

        System.out.printf("%.6f", result/gradeSum);

    }

    static double cal(double n, String s) {
        double grade = 0;

        switch (s) {
            case "A+":
                grade = 4.5;
                break;
            case "A0":
                grade = 4.0;
                break;
            case "B+":
                grade = 3.5;
                break;
            case "B0":
                grade = 3.0;
                break;
            case "C+":
                grade = 2.5;
                break;
            case "C0":
                grade = 2.0;
                break;
            case "D+":
                grade = 1.5;
                break;
            case "D0":
                grade = 1.0;
                break;
            case "F":
                grade = 0.0;
                break;
            default:
                grade = 0.0;
                break;
        }

        return n * grade;
    }
}
