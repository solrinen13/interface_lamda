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

    public   Task setTitle(int id, String string){
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

    public   Task setDescription(int id, String string){
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











}
