import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int degree = Integer.parseInt(st.nextToken());
            
            if (degree < 0) degree += 360;
            degree /= 45;

            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            while (degree-- > 0) {
                rotate(arr);
            }
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    bw.write(arr[i][j] + " ");
                }
                bw.write("\n");
            }
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
    
    static void rotate(int[][] arr) {
        int n = arr.length;
        int[] copy = new int[n];
        
        for (int i = 0; i < n; i++) {
            copy[i] = arr[i][n/2];
        }
        
        for (int i = 0; i < n; i++) {
            arr[i][n/2] = arr[i][i];
            arr[i][i] = arr[n/2][i];
            arr[n/2][i] = arr[n-i-1][i];
            arr[n-i-1][i] = copy[n-1-i];
        }
    }
}