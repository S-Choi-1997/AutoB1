import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            String extension = br.readLine().split("\\.")[1];
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }
        
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append(" ").append(map.get(s)).append("\n");
        }
        System.out.print(sb);
    }
}