package Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {




        List<Integer> list = new ArrayList<>();
        list.add(545);
        list.add(2);
        list.add(3);
        list.add(675);
        list.add(5);

        Stream<Integer> integerStream = list.stream();
        System.out.println("task №1");
        findMinMax(integerStream, Comparator.comparingInt(i -> i),(min,max)-> System.out.println("Минимальное = "+min+", Максимальное = "+max));

        Stream<Integer> taskTwoStream = list.stream();


        System.out.println(taskTwoStream.filter(E -> E % 2 == 0).count());
    }
      public static <T>void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer
      )
      {
        List<T>arrayList;
        T min = null;
        T max = null;
        arrayList = stream.collect(Collectors.toList());
          Optional<T>minX =arrayList.stream().min(order);
          Optional<T>maxX =arrayList.stream().max(order);

          if(arrayList.size() > 0){
              min = minX.get();
              max = maxX.get();
          }
          minMaxConsumer.accept(min,max);
      }
    }
