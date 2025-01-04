class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int len = arr.length;

        if (isTwo(len)){
            return arr;
        }

        int next = 1;
        while (next < len){
            next *= 2;
        }

        int[] result = new int[next];
        for (int i = 0; i < len; i++) {
            result[i] = arr[i];
        }

        return result;
    }


    private static boolean isTwo(int n){
        return (n & (n - 1 )) == 0;
    }
}