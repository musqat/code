import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        Integer[] number = new Integer[numbers.length];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            number[i] = numbers[i];
        }

        Arrays.sort(number, (a,b) -> {
            String ab = String.valueOf(a) + String.valueOf(b);
            String ba = String.valueOf(b) + String.valueOf(a);
            return ba.compareTo(ab);
        });


        if (number[0] == 0) {
            return "0";
        }

        for (Integer num : number) {
            sb.append(num);
        }

        return sb.toString();
    }
}
