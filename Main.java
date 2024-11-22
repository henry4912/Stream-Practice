import java.util.*;
import java.util.stream.Collectors;

public class Main {
  public static void main(String args[]) {
    // First unique character in a string
    String p1 = "hello world he";
    System.out.println(problem1(p1));
    
    // Top K frequency words
    List<String> words = Arrays.asList("hello", "world", "abc", "def", "abc", "def", "hello", "abc", "ghi", "def", "def");
    System.out.println(problem2(words, 3));
    
    // Sum of unique elements
    List<Integer> nums = Arrays.asList(1, 1, 2, 3, 3, 4, 4, 5, 6, 3, 2, 10); // 5 + 6 + 10 = 21
    System.out.println(problem3(nums));
            
  }
  
  public static int problem1(String str) {
    return str.chars()
            .filter(s -> str.indexOf((char) s) == str.lastIndexOf((char) s))
            .mapToObj(s -> (char) s)
            .findFirst()
            .map(s -> str.indexOf(s))
            .orElse(-1);
  }
  
  public static List<String> problem2(List<String> list, int k) {
    Map<String, Long> freq = list.stream()
                                 .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
    return freq.entrySet()
                .stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
  }
  
  public static int problem3(List<Integer> list) {
     Map<Integer, Long> freq = list.stream()
                                       .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
                                       
    return freq.entrySet()
               .stream()
               .filter(e -> e.getValue() == 1)
               .map(Map.Entry::getKey)
               .mapToInt(Integer::intValue)
               .sum();
                                       
  }
}
