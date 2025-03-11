import java.io.*;
import java.util.*;

class Node {
    char value;
    Node left, right;

    Node(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    Map<Character, Node> nodes = new HashMap<>();
    Node root;

    void addNode(char parent, char left, char right) {
        if (!nodes.containsKey(parent)) {
            nodes.put(parent, new Node(parent));
        }
        Node parentNode = nodes.get(parent);

        if (left != '.') {
            if (!nodes.containsKey(left)) {
                nodes.put(left, new Node(left));
            }
            parentNode.left = nodes.get(left);
        }

        if (right != '.') {
            if (!nodes.containsKey(right)) {
                nodes.put(right, new Node(right));
            }
            parentNode.right = nodes.get(right);
        }
    }

    void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(br.readLine());
        BinaryTree tree = new BinaryTree();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.addNode(parent, left, right);

        }
        tree.root = tree.nodes.get('A');

        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
        System.out.println();


    }

}
