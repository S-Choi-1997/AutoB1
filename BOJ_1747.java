import java.util.*;
import java.io.*;

public class Main {
    static int n;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        if (n == 1){
            System.out.println(2);
            System.exit(0);
        }
        for (int i = n; ; i++){
            if (isPalind(i) && isPrime(i)){
                System.out.println(i);
                System.exit(0);
            }
        }
    }
    
    public static boolean isPrime(int x){
        if(x < 2) return false;
        boolean[] isPrime = new boolean[x + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= x; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= x; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime[x];
    }
    
    public static boolean isPalind(int x) {
        String strX = Integer.toString(x);
        int cnt = strX.length();
        for (int i = 0; i <= cnt / 2; i++){
            if (strX.charAt(i) != strX.charAt(cnt-i-1)){
                return false;
            }
        }
        return true;
    }
}