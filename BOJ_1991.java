import java.util.*;
import java.io.*;

public class Main {
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Node[] orgArr = new Node[n];
        char al = 'A';
        for (int i = 0; i < n; i++) orgArr[i] = new Node(al++);
        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            orgArr[line[0] - 65].left = line[2] == '.' ? null : orgArr[line[2] - 65];
            orgArr[line[0] - 65].right = line[4] == '.' ? null : orgArr[line[4] - 65];
        }

        System.out.println(preorder(orgArr[0]));
        System.out.println(inorder(orgArr[0]));
        System.out.println(postorder(orgArr[0]));
    }

    private static String preorder(Node node) {
        String retVal = "";
        retVal += node.self;
        if (node.left != null) retVal += preorder(node.left);
        if (node.right != null) retVal += preorder(node.right);
        return retVal;
    }

    private static String inorder(Node node) {
        String retVal = "";
        if (node.left != null) retVal += inorder(node.left);
        retVal += node.self;
        if (node.right != null) retVal += inorder(node.right);
        return retVal;
    }

    private static String postorder(Node node) {
        String retVal = "";
        if (node.left != null) retVal += postorder(node.left);
        if (node.right != null) retVal += postorder(node.right);
        retVal += node.self;
        return retVal;
    }

    private static class Node {
        char self;
        Node left, right;

        public Node(char self) {
            this.self = self;
        }

        public String toString() {
            return self + "";
        }
    }
}