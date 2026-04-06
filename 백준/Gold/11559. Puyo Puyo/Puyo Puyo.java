import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String[][] board = new String[12][6]; // 12 x 6 뿌요칸
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static List<int[]> group;
    static int chain = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                board[i][j] = String.valueOf(s.charAt(j));
            }

        }
        while (true) {
            boolean boomed = false;
            visited = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (!board[i][j].equals(".") && !visited[i][j]) {
                        group = new ArrayList<>();
                        dfs(i, j, board[i][j]);
                        if (group.size() >= 4) {
                            boomed = true;
                            for (int[] pos : group) {
                                board[pos[0]][pos[1]] = ".";
                            }
                        }
                    }
                }

            }
            if (!boomed) break;
            chain++;
            gravity();
        }

        System.out.println(chain);
    }


    static void dfs(int row, int col, String color) {
        if (board[row][col].equals(".")) {
            return;
        }
        visited[row][col] = true;
        group.add(new int[]{row, col});

        for (int d = 0; d < 4; d++) {
            int nx = row + dx[d];
            int ny = col + dy[d];
            if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6) continue;
            if (visited[nx][ny]) continue;
            if (!board[nx][ny].equals(color)) continue;
            dfs(nx, ny, color);
        }
    }

    static void gravity() {
        for (int j = 0; j < 6; j++) {
            List<String> puyos = new ArrayList<>();
            for (int i = 11; i >= 0; i--) {
                if (!board[i][j].equals(".")) puyos.add(board[i][j]);
            }
            for (int i = 11; i >= 0; i--) {
                board[i][j] = (11 - i < puyos.size()) ? puyos.get(11 - i) : ".";
            }
        }
    }
}
