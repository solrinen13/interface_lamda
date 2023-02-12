package SecondCourse_CourseWork.Zadanie_na_func_prog;


import java.util.*;
import java.util.stream.Collectors;

public class TaskFunc {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String string = scanner.nextLine();
        List<String> words = Arrays.asList(string.split(" "));
        System.out.println("В тексте " + words.size() + " слов");
        System.out.println("ТОП 10:");

        words.stream().collect(Collectors.groupingBy(String::toLowerCase,Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .sorted(Comparator.comparingLong(Map.Entry<String, Long>::getValue).reversed())
                .limit(10)
                .forEachOrdered(pair-> System.out.println(pair.getValue()+ "-" + pair.getKey()));
    }
}
