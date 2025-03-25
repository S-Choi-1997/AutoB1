import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FileMergeCost {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++) {
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            while(st.hasMoreTokens()) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            long totalCost = 0;
            while(pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();
                totalCost += (a + b);
                pq.add(a + b);
            }
            sb.append(totalCost).append("\n");
        }
        System.out.print(sb.toString());
    }
}