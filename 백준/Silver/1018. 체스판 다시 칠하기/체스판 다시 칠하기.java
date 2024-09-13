import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N과 M을 입력받습니다.
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        
        // 보드의 상태를 저장할 2차원 배열을 생성합니다.
        char[][] board = new char[N][M];
        
        // 보드의 각 행을 입력받아 배열에 저장합니다.
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        
        int minRepaint = 64; // 최대 다시 칠해야 하는 수는 64입니다.
        
        // 모든 가능한 8×8 크기의 영역을 검사합니다.
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int repaintW = 0; // 좌측 상단이 흰색인 경우
                int repaintB = 0; // 좌측 상단이 검은색인 경우
                
                // 8×8 영역 내의 모든 칸을 검사합니다.
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        char currentColor = board[i + x][j + y];
                        // 좌표의 합이 짝수인 경우와 홀수인 경우로 나눕니다.
                        if ((x + y) % 2 == 0) {
                            if (currentColor != 'W') repaintW++;
                            if (currentColor != 'B') repaintB++;
                        } else {
                            if (currentColor != 'B') repaintW++;
                            if (currentColor != 'W') repaintB++;
                        }
                    }
                }
                
                // 두 경우 중 최소 값을 선택하여 minRepaint를 갱신합니다.
                int repaint = Math.min(repaintW, repaintB);
                if (repaint < minRepaint) {
                    minRepaint = repaint;
                }
            }
        }
        
        // 결과를 출력합니다.
        System.out.println(minRepaint);
    }
}
