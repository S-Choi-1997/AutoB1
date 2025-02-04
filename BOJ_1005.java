public class CombinedBlogCode {
    public static void main(String[] args) {
        int[] numbers = {3, 7, 2, 9, 1};
        int sum = 0;
        int max = numbers[0];
        
        System.out.print("원본 배열: ");
        for (int num : numbers) {
            System.out.print(num + " ");
            sum += num;
            if (num > max) {
                max = num;
            }
        }
        
        System.out.println("\n합계: " + sum);
        System.out.println("최대값: " + max);
        
        String[][] users = {{"Alice", "28"}, {"Bob", "32"}, {"Charlie", "25"}};
        System.out.println("\n사용자 정보:");
        for (String[] user : users) {
            System.out.println("이름: " + user[0] + ", 나이: " + user[1]);
        }
        
        int factorialResult = 1;
        for (int i = 1; i <= 5; i++) {
            factorialResult *= i;
        }
        System.out.println("\n5! = " + factorialResult);
    }
}