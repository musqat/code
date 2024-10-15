import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Queue<int[]> queue = new LinkedList<>();
            int[] priorities = new int[n];

            for (int j = 0; j < n; j++) {
                priorities[j] = sc.nextInt();
                queue.add(new int[]{j, priorities[j]});
            }

            int printOrder = 0;

            while (!queue.isEmpty()){
                int[] current = queue.poll();
                boolean isHigherPriority = false;

                for(int[] doc : queue){
                    if (doc[1] > current[1]){
                        isHigherPriority = true;
                        break;
                    }
                }

                if (isHigherPriority){
                    queue.add(current);
                }else {
                    printOrder++;
                    if (current[0] == m){
                        System.out.println(printOrder);
                        break;
                    }
                }

            }
        }
        sc.close();

    }
}
