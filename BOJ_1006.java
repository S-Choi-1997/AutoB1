import java.util.ArrayList;
import java.util.List;

public class BlogDataProcessor {
    public static void main(String[] args) {
        List<String> summaries = new ArrayList<>();
        summaries.add("[요약1] Java 기본 문법 설명");
        summaries.add("[요약2] 컬렉션 프레임워크 활용법");
        summaries.add("[요약3] 멀티스레드 프로그래밍 기초");

        List<String> codes = new ArrayList<>();
        codes.add("System.out.println(\"Hello World\");");
        codes.add("List<String> list = new ArrayList<>();");
        codes.add("ExecutorService executor = Executors.newFixedThreadPool(5);");

        DataMerger merger = new DataMerger();
        merger.mergeData(summaries, codes);
        merger.displayResults();
    }
}

class DataMerger {
    private List<String> mergedResults = new ArrayList<>();

    public void mergeData(List<String> texts, List<String> codes) {
        validateInput(texts, codes);
        
        for (int i = 0; i < texts.size(); i++) {
            mergedResults.add(texts.get(i) + "\n" + codes.get(i));
        }
    }

    public void displayResults() {
        mergedResults.forEach(result -> {
            System.out.println("----------------------");
            System.out.println(result);
            System.out.println("----------------------");
        });
    }

    private void validateInput(List<String> list1, List<String> list2) {
        if (list1.size() != list2.size()) {
            throw new IllegalArgumentException("두 입력 리스트의 크기가 동일해야 합니다");
        }
    }
}