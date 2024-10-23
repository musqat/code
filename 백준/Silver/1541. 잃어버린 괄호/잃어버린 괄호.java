import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] arr = str.split("-");

        int sum = Integer.MAX_VALUE;
        

        for (int i = 0; i < arr.length; i++) {
            int temp = 0;
            
            String[] plus = arr[i].split("\\+");

            for (int j = 0; j < plus.length; j++) {
                temp += Integer.parseInt(plus[j]);    
                
            }
            
            if (sum == Integer.MAX_VALUE){
                sum = temp;
            }else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
