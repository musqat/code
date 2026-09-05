import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        int kind = toIndex(ext);
        int sort = toIndex(sort_by);

        for (int i = 0; i < data.length; i++) {
            if (data[i][kind] < val_ext) {
                list.add(data[i]);
            }
        }
        list.sort(Comparator.comparingInt(a -> a[sort]));

        return list.toArray(new int[list.size()][]);
    }

    private int toIndex(String name) {
        return switch (name) {
            case "code" -> 0;
            case "date" -> 1;
            case "maximum" -> 2;
            case "remain" -> 3;
            default -> -1;
        };

    }
}