class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder answer = new StringBuilder(my_string);


        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            String sub = answer.substring(start, end + 1);
            String reverse = new StringBuilder(sub).reverse().toString();
            answer.replace(start, end + 1, reverse); 
        }

        return answer.toString();
    }
}