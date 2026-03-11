import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String[]> students = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String day = st.nextToken();
            String month = st.nextToken();
            String year = st.nextToken();
            students.add(new String[]{name, day, month, year});
        }
        Comparator<String[]> birth = Comparator
                .comparingInt((String[] s) -> Integer.parseInt(s[3]))
                .thenComparingInt((s) -> Integer.parseInt(s[2]))
                .thenComparingInt(s -> Integer.parseInt(s[1]));

        students.sort(birth);

        System.out.println(students.get(N-1)[0]);
        System.out.println(students.get(0)[0]);
    }
}
