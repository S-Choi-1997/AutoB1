import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    que.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (que.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(que.poll()).append("\n");
                    break;
                case "size":
                    sb.append(que.size()).append("\n");
                    break;
                case "empty":
                    if (que.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if (que.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(que.peek()).append("\n");
                    break;
                case "back":
                    if (que.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(que.peekLast()).append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}