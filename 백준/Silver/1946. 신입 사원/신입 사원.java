import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class people {
        int paper;
        int interview;

        public people(int paper, int interview) {
            this.paper = paper;
            this.interview = interview;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            List<people> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int paper = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                list.add(new people(paper, interview));
            }

            list.sort((Comparator.comparingInt(a -> a.paper)));

            int count = 1;
            int minInterview = list.get(0).interview;

            for (int i = 1; i < N; i++) {
                if (list.get(i).interview < minInterview){
                    count++;
                    minInterview = list.get(i).interview;
                }
            }

            System.out.println(count);


        }

    }
}
