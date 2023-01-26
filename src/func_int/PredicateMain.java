package func_int;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class PredicateMain { public static void main(String[] args) {
    Person person1 = new Person("Ted", 24);
    Person person2 = new Person("Te", 23);
    Person person3 = new Person("Tedy", 22);
    Person person4 = new Person("Tedart", 21);
    Person person5 = new Person("Tedvan", 20);

    List<Person> people = new ArrayList<>();
    people.add(person1);
    people.add(person2);
    people.add(person3);
    people.add(person4);
    people.add(person5);

     /*   for (Person person : people) {
            System.out.println(person);
        }*/

    Predicate<Person> predicate = new Predicate<Person>() {
        @Override
        public boolean test(Person person) {
            return false;
        }
    };

    PersonSortingBeAge personSortingBeAge = new PersonSortingBeAge();
    people.sort(personSortingBeAge);
    for (Person person : people) {
        System.out.println("--------------------");
        System.out.println(person);
    }
}
}

class PebrsonSortingBeAge implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getAge() > o2.getAge()){
            return 1;
        }else if(o1.getAge() < o2.getAge()){
            return -1;
        }
        return 0;
    }
}
