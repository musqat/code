import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(LocalDateTime.now().getYear());
        System.out.printf("%02d %n",LocalDateTime.now().getMonthValue());
        System.out.println(LocalDateTime.now().getDayOfMonth());
    }
}