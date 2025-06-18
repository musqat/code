import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static Map<Integer, Character> dirChanges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int apple = Integer.parseInt(br.readLine());

        board = new int[N][N];


        for (int i = 0; i < apple; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            board[x][y] = 2; // 사과
        }

        int L = Integer.parseInt(br.readLine());
        dirChanges = new HashMap<>();

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            dirChanges.put(X, C);


        }

        snake(0, 0);

    }

    public static void snake(int x, int y) {
        int time = 0;
        int dir = 0; // 오른쪽

        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{x, y});
        board[x][y] = 1;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while (true) {
            time++;

            int[] head = snake.peekLast();
            int nx = head[0] + dx[dir];
            int ny = head[1] + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == 1){
                break;
            }

            if (board[nx][ny] == 2){
                board[nx][ny] = 1;
                snake.addLast(new int[]{nx, ny});
            }else {
                board[nx][ny] = 1;
                snake.addLast(new int[]{nx, ny});
                int[] tail = snake.pollFirst();
                board[tail[0]][tail[1]] = 0;
            }

            if (dirChanges.containsKey(time)){
                char turn = dirChanges.get(time);
                if (turn == 'L') dir = (dir + 3) % 4;
                else if (turn == 'D') dir = (dir + 1) % 4;
            }
        }

        System.out.println(time);
    }
}
