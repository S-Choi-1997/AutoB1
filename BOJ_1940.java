import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // N과 M을 입력받음
        int N=sc.nextInt();
        int M=sc.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt(); // 배열의 각 원소를 입력받음
        }
        Arrays.sort(arr); // 배열을 오름차순으로 정렬
        int S=0; // 시작 인덱스
        int E=N-1; // 끝 인덱스
        int count=0; // M을 만족하는 쌍의 수
        while (S<E){
            if(arr[S]+arr[E]<M){
                S++; // 합이 M보다 작으면 시작 인덱스를 오른쪽으로 이동
            } else if (arr[S]+arr[E]>M) {
                E--; // 합이 M보다 크면 끝 인덱스를 왼쪽으로 이동
            } else {
                count++; // 합이 M과 같으면 카운트 증가
                E--; // 끝 인덱스를 왼쪽으로 이동
            }
        }
        System.out.println(count); // 결과 출력
    }
}