import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamWork {
    public static void main(String[] args) {
        //Напишите удаление всех повторяющихся элементов из списка
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(44);
        list.add(10);
        list.add(653);
        list.add(653);
        List<Integer> distinctInts = list.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctInts);
        //Напишите подсчет количества строк в списке, которые начинаются с определенной буквы
        List<String> stringList = new ArrayList<>();
        stringList.add("Хрюшка");
        stringList.add("Тамуалипас");
        stringList.add("Хиросима");
        List<String> strOnlyX = stringList.stream()
                .filter(s -> s.startsWith("Х")).toList();
        System.out.println(strOnlyX.size());
        //Используя оператор findFirst напишите поиск второго по величине элемента в списке целых чисел
                List<Integer> numbers = Arrays.asList(4, 1, 7, 7, 9, 5, 6);

                Optional<Integer> secondLargest = findSecondLargest(numbers);

                secondLargest.ifPresentOrElse(
                        value -> System.out.println("Второе по величине число: " + value),
                        () -> System.out.println("Второе по величине число не найдено.")
                );

    }
    public static Optional<Integer> findSecondLargest(List<Integer> numbers) {
        return numbers.stream()
                .distinct() // Убираем дубликаты
                .sorted((a, b) -> Integer.compare(b, a)) // Сортируем по убыванию
                .skip(1) // Пропускаем первое по величине
                .findFirst(); // Находим первое (второе по величине)
    }
}
