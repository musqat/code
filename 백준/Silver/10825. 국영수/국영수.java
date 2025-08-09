import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Student {
        String name;
        int kor, eng, math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        static final Comparator<Student> BY_GRADE = (a, b) -> {
            int c;
            c = Integer.compare(b.kor, a.kor);
            if (c != 0) return c;
            c = Integer.compare(a.eng, b.eng);
            if (c != 0) return c;
            c = Integer.compare(b.math, a.math);
            if (c != 0) return c;

            return a.name.compareTo(b.name);
        };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Student> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Student(name, a, b, c));
        }

        list.sort(Student.BY_GRADE);

        for (Student s : list) {
            System.out.println(s.name);
        }

    }
}
