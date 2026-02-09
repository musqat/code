import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1}; //상하좌우
    static int[] dy = {1, -1, 0, 0}; //상하좌우

    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        int row = maps.length;
        int col = maps[0].length();
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    answer.add(bfs(i, j, visited, maps));
                }


            }
        }

        if (answer.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(answer);
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;

    }

    private int bfs(int x, int y, boolean[][] visited, String[] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int total = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            total += maps[curX].charAt(curY) - '0';

            for (int d = 0; d < 4; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                if (nx < maps.length && nx >= 0 && ny < maps[curX].length() && ny >= 0) {
                    if (maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }

        }
        return total;
    }
}