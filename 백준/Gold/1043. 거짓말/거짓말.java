import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;

    static int find(int x){
        if (parent[x] == x ) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        List<Integer> truthPeople = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            truthPeople.add(Integer.parseInt(st.nextToken()));
        }

        List<List<Integer>> parties = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            for (int j = 0; j < party.size() - 1; j++) {
                union(party.get(j), party.get(j + 1));
            }


            parties.add(party);
        }

        Set<Integer> truthRoots = new HashSet<>();
        for (int p : truthPeople){
            truthRoots.add(find(p));
        }

        int result = 0;
        for (List<Integer> party : parties){
            boolean canLie = true;
            for (int person : party){
                if (truthRoots.contains(find(person))){
                    canLie = false;
                    break;
                }
            }

            if (canLie) result++;
        }

        System.out.println(result);
    }
}
