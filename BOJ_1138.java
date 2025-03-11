import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfPerson = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] leftCounts = new int[numOfPerson + 1];
        List<Integer> result = new LinkedList<>();

        for (int i = 1; i <= numOfPerson; i++) {
            leftCounts[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = numOfPerson; i >= 1; i--) {
            result.add(leftCounts[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int su : result) {
            sb.append(su).append(" ");
        }
        System.out.println(sb);
    }
}