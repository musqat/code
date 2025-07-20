import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        long[] arr = new long[A];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        int[] prev = new int[A];
        Arrays.fill(prev, -1);

        List<Long> list = new ArrayList<>();
        List<Integer> idxList = new ArrayList<>();

        for (int i = 0; i < A; i++) {
            int idx = Collections.binarySearch(list, arr[i]);
            if (idx < 0) {
                idx = -(idx + 1);
            }

            if (idx == list.size()) {
                list.add(arr[i]);
                idxList.add(i);
            } else {
                list.set(idx, arr[i]);
                idxList.set(idx, i);
            }

            if (idx > 0) {
                prev[i] = idxList.get(idx - 1);
            }
        }

        System.out.println(list.size());

        int lastIndex = idxList.get(list.size() - 1);
        Stack<Long> stack = new Stack<>();
        while (lastIndex != -1) {
            stack.push(arr[lastIndex]);
            lastIndex = prev[lastIndex];
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
