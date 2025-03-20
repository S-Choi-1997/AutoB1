import java.io.*;
import java.util.Arrays;

public class CombineArray_11728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] a = new int[n];
        int[] b = new int[m];

        String[] arr1 = br.readLine().split(" ");
        String[] arr2 = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(arr1[i]);
        }
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(arr2[i]);
        }

        int p1 = 0, p2 = 0;

        while (p1 < n && p2 < m) {
            if (a[p1] <= b[p2]) {
                sb.append(a[p1++] + " ");
            } else {
                sb.append(b[p2++] + " ");
            }
        }

        while (p1 < n) {
            sb.append(a[p1++] + " ");
        }
        while (p2 < m) {
            sb.append(b[p2++] + " ");
        }

        System.out.println(sb);
    }
}