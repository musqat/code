import java.io.*;

public class Main {
    static int N;
    static char[][] grid;
    static boolean[][] visitNormal;
    static boolean[][] visitColorblind;

    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            grid[i] = line.toCharArray();
        }

        visitNormal = new boolean[N][N];
        visitColorblind = new boolean[N][N];

        int countNormal = 0;
        int countColorblind = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitNormal[i][j]) {
                    dfs(i, j, grid[i][j], visitNormal, false);
                    countNormal++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitColorblind[i][j]) {
                    dfs(i, j, grid[i][j], visitColorblind, true);
                    countColorblind++;
                }
            }
        }

        System.out.println(countNormal + " " + countColorblind);

    }

    public static void dfs(int x, int y, char color, boolean[][] visited, boolean isColorblind) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                char nextColor = grid[nx][ny];

                if (isColorblind) {
                    if (isSameColorForColorblind(color, nextColor)) {
                        dfs(nx, ny, nextColor, visited, isColorblind);
                    }
                } else {
                    if (nextColor == color) {
                        dfs(nx, ny, nextColor, visited, isColorblind);
                    }
                }
            }
        }
    }

    public static boolean isSameColorForColorblind(char color1, char color2) {
        if (color1 == 'B' && color2 == 'B') {
            return true;
        }
        if ((color1 == 'R' || color1 == 'G') && (color2 == 'R' || color2 == 'G')) {
            return true;
        }
        return false;
    }
}
