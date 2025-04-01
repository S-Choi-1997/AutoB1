import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = -1;

        for(int i = n / 5; i >= 0; i--) {
            int except5 = n - (5 * i);
            if(except5 % 2 == 0) {
                ans = except5 / 2 + i;
                break;
            }
        }
        System.out.println(ans);
    }
}