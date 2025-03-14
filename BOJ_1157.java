import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // 영문자의 개수는 26개임
        int[] arr = new int[26]; 
        String s = in.next().toUpperCase(); // 입력받은 문자열을 대문자로 변환
        
        // 문자열의 각 문자에 대해 빈도수 계산
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'A']++; // 해당 인덱스의 값 1 증가
        }

        int max = -1;
        char ch = '?';

        // 가장 많이 사용된 알파벳 찾기
        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                ch = (char) (i + 'A');
            } else if (arr[i] == max) {
                ch = '?';
            }
        }

        System.out.print(ch);
    }
}