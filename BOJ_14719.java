import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] blocks = new int[w];

        // 블록 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(countRain(blocks));
    }
    
    private static int countRain(int[] blocks) {
        int cnt = 0;
        int length = blocks.length;

        // 왼쪽과 오른쪽에서 가장 높은 블록의 높이를 저장할 배열
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];

        // 왼쪽에서 오른쪽으로 최대 블록 높이 기록
        leftMax[0] = blocks[0];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], blocks[i]);
        }

        // 오른쪽에서 왼쪽으로 최대 블록 높이 기록
        rightMax[length - 1] = blocks[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], blocks[i]);
        }

        // 고인 물의 양 계산
        for (int i = 1; i < length - 1; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            if (minHeight > blocks[i]) {
                cnt += minHeight - blocks[i];
            }
        }

        return cnt;
    }
}