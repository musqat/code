import java.util.ArrayList;

class Solution {
    public String[] solution(String[] str_list) {
        ArrayList<String> lList = new ArrayList<>();
        ArrayList<String> rList = new ArrayList<>();

        for (int i = 0; i < str_list.length; i++) {
            if (str_list[i].equals("l") ){
                return lList.toArray(new String[0]);
            } else if (str_list[i].equals("r")) {
                for (int j = i + 1; j < str_list.length; j++) {
                    rList.add(str_list[j]);
                }
                return rList.toArray(new String[0]);
            }else {
                lList.add(str_list[i]);

            }
        }

        return new String[0];
    }
}