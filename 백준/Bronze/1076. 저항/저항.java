import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        String[] colors = {"black","brown","red","orange","yellow","green","blue","violet","grey","white"};

        for (int i = 0; i < colors.length; i++) {
            map.put(colors[i], i);
        }

        String c1 = br.readLine();
        String c2 = br.readLine();
        String c3 = br.readLine();

        long value = map.get(c1) * 10 + map.get(c2);
        long multiplier = (long) Math.pow(10, map.get(c3));

        System.out.println(value * multiplier);
    }
}
