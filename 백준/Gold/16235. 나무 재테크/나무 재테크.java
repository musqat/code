import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] A; // 추가 양분
    static int[][] nutrient; //양분
    static ArrayList<Integer>[][] trees; // 나무들
    static ArrayList<Integer>[][] deadTrees; // 죽은 나무
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        nutrient = new int[N][N];
        trees = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                nutrient[i][j] = 5;
                trees[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            trees[x][y].add(z);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Collections.sort(trees[i][j]);
            }
        }

        for (int i = 0; i < K; i++) {
            spring();
            summer();
            fall();
            winter();
        }


        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count += trees[i][j].size();
            }

        }

        System.out.println(count);

    }

    static void spring() {
        deadTrees = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                deadTrees[i][j] = new ArrayList<>();

                if (trees[i][j].isEmpty()) continue;

                ArrayList<Integer> alive = new ArrayList<>();

                for (int age : trees[i][j]) {
                    if (nutrient[i][j] >= age) {
                        nutrient[i][j] -= age;
                        alive.add(age + 1);
                    } else {
                        deadTrees[i][j].add(age);
                    }
                }

                trees[i][j] = alive;

            }
        }
    }

    static void summer() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int age : deadTrees[i][j]) {
                    nutrient[i][j] += age / 2;
                }

            }

        }

    }

    static void fall() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int age : trees[i][j]) {
                    if (age % 5 == 0) {
                        for (int d = 0; d < 8; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];

                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                trees[nx][ny].add(0, 1);
                            }
                        }
                    }
                }
            }
        }
    }

    static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nutrient[i][j] += A[i][j];
            }
        }
    }


}