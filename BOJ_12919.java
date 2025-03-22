import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		
		System.out.println(canTransform(s, t) ? 1 : 0);
	}
	
	static boolean canTransform(String s, String t) {
		if(s.length() >= t.length()) {
			return s.equals(t);
		}
		
		if(t.charAt(t.length() - 1) == 'A' && canTransform(s, t.substring(0, t.length() - 1))) {
			return true;
		}
		if(t.charAt(0) == 'B' && canTransform(s, new StringBuilder(t).reverse().substring(0, t.length() - 1))) {
			return true;
		}
		
		return false;
	}
}