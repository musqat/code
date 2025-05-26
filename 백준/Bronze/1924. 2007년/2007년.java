import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        LocalDate date = LocalDate.of(2007, m,d);

        String[] map = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int idx = date.getDayOfWeek().getValue() % 7;
        System.out.println(map[idx]);


    }

}
