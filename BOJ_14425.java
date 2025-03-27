import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static class TrieNode {
        Map<Character, TrieNode> childNode = new HashMap<>();
        boolean terminal;

        public void insert(String word) {
            TrieNode trieNode = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                trieNode.childNode.putIfAbsent(c, new TrieNode());
                trieNode = trieNode.childNode.get(c);
                if (i == word.length() - 1) {
                    trieNode.terminal = true;
                    return;
                }
            }
        }

        public boolean contains(String word) {
            TrieNode trieNode = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode node = trieNode.childNode.get(c);
                if (node == null) {
                    return false;
                }
                trieNode = node;
            }
            return trieNode.terminal;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TrieNode tNode = new TrieNode();

        for (int i = 0; i < n; i++) {
            tNode.insert(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            if (tNode.contains(br.readLine())) {
                count++;
            }
        }
        System.out.println(count);
    }
}