import java.util.*;

public class Main {
    static class Node {
        int num;
        String commands;

        Node(int num, String commands) {
            this.num = num;
            this.commands = commands;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(bfs(arr[i][0], arr[i][1]));
        }
    }

    public static String bfs(int A, int B) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        queue.add(new Node(A, ""));
        visited[A] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int num = current.num;
            String commands = current.commands;

            if (num == B) {
                return commands;
            }

            // D
            int D = (num * 2) % 10000;
            if (!visited[D]) {
                visited[D] = true;
                queue.add(new Node(D, commands + "D"));
            }

            // S
            int S = (num == 0) ? 9999 : num - 1;
            if (!visited[S]) {
                visited[S] = true;
                queue.add(new Node(S, commands + "S"));
            }

            // L
            int L = (num % 1000) * 10 + num / 1000;
            if (!visited[L]) {
                visited[L] = true;
                queue.add(new Node(L, commands + "L"));
            }

            // R
            int R = (num % 10) * 1000 + num / 10;
            if (!visited[R]) {
                visited[R] = true;
                queue.add(new Node(R, commands + "R"));
            }
        }
        return "";
    }
}
