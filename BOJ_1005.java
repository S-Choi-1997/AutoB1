import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] node = new int[N];
            int[] time = new int[N];
            int[] result = new int[N];
            ArrayList<Integer>[] arr = new ArrayList[N];

            for (int i = 0; i < N; i++) {
                arr[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr[x - 1].add(y - 1);
                node[y - 1]++;
            }

            int W = Integer.parseInt(br.readLine());

            Queue<Integer> qu = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                if (node[i] == 0) {
                    result[i] = time[i];
                    qu.add(i);
                }
            }

            while (!qu.isEmpty()) {
                int b = qu.poll();

                for (int i : arr[b]) {
                    result[i] = Math.max(result[i], time[i] + result[b]);
                    if (--node[i] == 0)
                        qu.add(i);
                }
            }

            System.out.println(result[W - 1]);
        }
    }
}