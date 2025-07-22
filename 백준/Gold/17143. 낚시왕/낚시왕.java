import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 1, -1};

    static class Shark {
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        List<Shark> sharks = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            sharks.add(new Shark(r, c, s, d, z));
        }

        int totalSize = 0;

        for (int i = 0; i < C; i++) {
            int minRow = R;
            Shark target = null;


            for (Shark shark : sharks) {
                if (shark.c == i && shark.r < minRow) {
                    minRow = shark.r;
                    target = shark;
                }
            }

            if (target != null) {
                totalSize += target.z;
                sharks.remove(target);
            }

            sharks = moveSharks(sharks, R, C);
        }

        System.out.println(totalSize);
    }

    static List<Shark> moveSharks(List<Shark> sharks, int R, int C) {
        Shark[][] newBoard = new Shark[R][C];

        for (Shark shark : sharks) {
            int speed = shark.s;
            int dir = shark.d;
            int x = shark.r;
            int y = shark.c;

            if (dir == 1 || dir == 2) speed %= (R - 1) * 2;
            else speed %= (C - 1) * 2;

            for (int i = 0; i < speed; i++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    if (dir == 1) dir = 2;
                    else if (dir == 2) dir = 1;
                    else if (dir == 3) dir = 4;
                    else if (dir == 4) dir = 3;

                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }

                x = nx;
                y = ny;

            }

            if (newBoard[x][y] == null || newBoard[x][y].z < shark.z) {
                newBoard[x][y] = new Shark(x, y, shark.s, dir, shark.z);
            }

        }

        List<Shark> result = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (newBoard[i][j] != null) {
                    result.add(newBoard[i][j]);
                }

            }

        }
        return result;
    }
}
