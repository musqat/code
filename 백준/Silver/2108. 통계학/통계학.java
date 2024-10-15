import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        int sum = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;


        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            sum += numbers[i];
            freqMap.put(numbers[i], freqMap.getOrDefault(numbers[i], 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(numbers[i]));
        }

        System.out.println(Math.round((double) sum / N));

        Arrays.sort(numbers);
        System.out.println(numbers[N / 2]);

        List<Integer> modeList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                modeList.add(entry.getKey());
            }
        }
        Collections.sort(modeList);
        if (modeList.size() > 1) {
            System.out.println(modeList.get(1));
        } else {
            System.out.println(modeList.get(0));
        }

        int range = numbers[N - 1] - numbers[0];
        System.out.println(range);
    }
}
