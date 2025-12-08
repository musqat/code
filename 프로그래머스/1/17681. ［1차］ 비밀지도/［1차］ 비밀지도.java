class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String a1 = String.format("%" + n + "s", Integer.toBinaryString(arr1[i])).replace(' ', '0');
            String a2 = String.format("%" + n + "s", Integer.toBinaryString(arr2[i])).replace(' ', '0');
            
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (a1.charAt(j) == '1' || a2.charAt(j) == '1'){
                    sb.append("#");
                }else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
}