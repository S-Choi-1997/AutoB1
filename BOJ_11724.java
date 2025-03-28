import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int arr[][];
    static boolean visit[];
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                dfs(i);
                result++;
            }
        }
        System.out.println(result);
    }

    public static void dfs(int node) {
        visit[node] = true;

        for (int i = 1; i <= N; i++) {
            if (!visit[i] && arr[node][i] == 1) {
                dfs(i);
            }
        }
    }
}