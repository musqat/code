import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] box = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                box[i][j] = sc.nextInt();
            }
        }

        System.out.println(tomato(M,N, box));
    }

    public static int tomato(int M, int N, int[][] box) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 1){
                    queue.add(new int[]{i, j});
                }else if (box[i][j] == 0){
                    count++;
                }
            }
        }

        if (count == 0){
            return 0;
        }

        int days = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0], y = current[1];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0){
                        box[nx][ny] = 1;
                        queue.add(new int[]{nx, ny});
                        count--;
                    }
                }

            }
            days++;
        }

        return count == 0 ? days - 1 : -1;
    }
}
