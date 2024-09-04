import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            switch (command) {
                case "pop":
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(queue.poll()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(queue.peek()).append("\n");
                    }
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(((LinkedList<Integer>) queue).getLast()).append("\n");
                    }
                    break;
                default: 
                    String[] parts = command.split(" ");
                    int value = Integer.parseInt(parts[1]);
                    queue.add(value);
                    break;
            }
        }

        System.out.print(sb);
        br.close();
    }
}