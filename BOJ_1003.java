import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static Integer[][] arr = new Integer[41][2];
	static int N = 0;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
        
		arr[0][0] = 1;
		arr[0][1] = 0;
		arr[1][0] = 0;
		arr[1][1] = 1;

		for(int i = 0 ; i < N ; i++) {
			int n = Integer.parseInt(br.readLine());
			fibonacci(n);
			sb.append(arr[n][0]).append(" ").append(arr[n][1]).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void fibonacci(int n) {		
		for(int i = 2 ; i <= n ; i++) {
			arr[i][0] = arr[i - 1][0] + arr[i - 2][0];
			arr[i][1] = arr[i - 1][1] + arr[i - 2][1];
		}
	}
}