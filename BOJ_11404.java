import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main{
    static int map[][];
    static final int INF = 9900001;

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        
        for(int i=1; i<=n; i++) {
            Arrays.fill(map[i], INF);
        }

        for(int i=1; i<=n; i++) {
            map[i][i] = 0;
        }

        for(int i=0; i<m; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            map[s][e] = Math.min(w, map[s][e]); 
        }
        
        floydWarshall(n);
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                sb.append(map[i][j] == INF ? "0 " : map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    public static void floydWarshall(int n) {
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                if(i==k) continue;
                for(int j=1; j<=n; j++) {
                    if(i==j || j==k) continue;
                    if(map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
    }
}