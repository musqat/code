import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int num;
        Node left;
        Node right;

        Node(int num) {
            this.num = num;
        }


        public Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        void add(int n) {
            if (n < this.num) {
                if (this.left == null) {
                    this.left = new Node(n);
                } else {
                    this.left.add(n);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(n);
                } else {
                    this.right.add(n);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        Node N = new Node(Integer.parseInt(br.readLine()));
        String s;
        while (true){
            s = br.readLine();
            if (s == null || s.equals("")){
                break;
            }
            N.add(Integer.parseInt(s));
        }

        postOrder(N);

    }

    static void postOrder(Node node){
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }

}
