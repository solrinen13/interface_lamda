package SecondCourse_CourseWork;

import SecondCourse_CourseWork.AllException.IncorrectArgumentException;
import SecondCourse_CourseWork.AllException.TaskNotFoundException;
import SecondCourse_CourseWork.DateTask.DailyTask;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class TaskService {

    Map<Integer, Task> taskMap = new HashMap<>();
    Collection<Task> removedTasks = new ArrayList<>();

    Map<LocalDate, Collection<Task>> taskMapByDate = new HashMap<>();
    public  Task remove(int id){
        if(id <= 0){
            throw  new IncorrectArgumentException(String.valueOf(id));
        }

        Task task = taskMap.remove(id);
        if (task == null){
            throw new TaskNotFoundException("Задача с ID = " + id + " отсутствует");
        }
        System.out.println("Задача с ID = " + id + " удалена");
        removedTasks.add(task);
        return task;
    }

    public   Task updateTitle(int id, String string){
        if(id <= 0){
            throw  new IncorrectArgumentException(String.valueOf(id));
        }
        Task task = taskMap.get(id);

        if (task == null){
            throw new TaskNotFoundException("Задача с ID = " + id + " отсутствует");
        }
        System.out.println("Задача с ID = " + id + " изменила название");

        task.setTitle(string);
        return task;
    }

    public   Task updateDescription(int id, String string){
        if(id <= 0){
            throw  new IncorrectArgumentException(String.valueOf(id));
        }
        Task task = taskMap.get(id);

        if (task == null){
            throw new TaskNotFoundException("Задача с ID = " + id + " отсутствует");
        }
        System.out.println("Задача с ID = " + id + " изменила содержание");

        task.setDescription(string);
        return task;
    }

    public void addTask(Task task) {

        taskMap.put(task.getId(),task);
        System.out.println("Задача добавлена и ее ID = " + task.getId());

    }

     public Collection <Task> getAllByDate(LocalDate localDate){

        return taskMap
                .values()
                .stream()
                .filter(e-> e.appearsIn(localDate))
                .collect(Collectors.toList());
    }

    public Collection <Task> getRemovedTasks (LocalDate localDate){

        return removedTasks;
    }




    public void groupByDate() {
        System.out.println("Available tasks grouped by date: ");
        Comparator<Map.Entry<Integer, Task>> myComparator = Comparator.comparing(o -> o.getValue().getDateTask());
        Map<Integer, Task> sortedMap = taskMap.entrySet().stream()
                .sorted(myComparator)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));
        sortedMap.entrySet().forEach(System.out::println);
    }







}
