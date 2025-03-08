import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // 입력을 받는다.
        int copy = n; // n의 값을 복사
        int count = 0; // 사이클 횟수 
        
        while (true) {
            int ten = copy / 10; // 십의 자리
            int one = copy % 10; // 일의 자리
            
            copy = one * 10 + (ten + one) % 10; // 새로운 수 생성
            count++;
            
            if (copy == n) // 처음 주어진 수와 새로운 수가 같을 경우
                break;
        }
        
        System.out.println(count);
        sc.close();
    }
}