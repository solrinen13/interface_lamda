package SecondCourse_CourseWork;

import SecondCourse_CourseWork.AllException.IncorrectArgumentException;
import SecondCourse_CourseWork.DateTask.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;

public class TaskApp {

    static TaskService service = new TaskService();
    static Scanner scanner =   new Scanner(System.in);

    public static  void main(String[] args) {

//        var lDate = LocalDate.parse("2020-02-29");
//        var task = new MonthlyTask("",Type.WORK, lDate.atStartOfDay(),"");
//
//        printTestResult(task.appearsIn(LocalDate.parse("2020-01-01")), false); //date before the task
//        printTestResult(task.appearsIn(LocalDate.parse("2020-02-01")), false); //date before the task, yet same month
//        printTestResult(task.appearsIn(LocalDate.parse("2020-02-29")), true); //the same date with the task
//        printTestResult(task.appearsIn(LocalDate.parse("2020-03-29")), true); //the next date for the task
//        printTestResult(task.appearsIn(LocalDate.parse("2020-03-31")), false); //the date at the end of the next month - NEGATIVE CASE
//        printTestResult(task.appearsIn(LocalDate.parse("2020-04-29")), true); //the next date for the task
//        printTestResult(task.appearsIn(LocalDate.parse("2021-02-28")), true); //one year later, should match

        while (true) {

            System.out.println("1 - check task");
            System.out.println("2 - add task");
            System.out.println("3 - remove task");
            System.out.println("4 - exit");
            System.out.println("Enter value: ");

            int takenValue = Integer.parseInt(scanner.nextLine());
            if (takenValue == 4) {
                System.exit(0);
            }
            switch (takenValue) {
                case 1:
                      service.getAllByDate(LocalDate.now()).forEach(System.out::println);
                      //.getId()+" "+task.getType()+" "+task.getTitle()+" "+task.getDescription()
                    // System.out.println("Enter value: ");
                    //takenValue = 0;
                   // caseOneMenu(takenValue);
                   // list.showByValue(valueDate);
                    break;
                case 2:
                  addNewTask();
                    break;
                case 3:
                    System.out.println("Enter the task ID: ");
                    int taskId = Integer.parseInt(scanner.nextLine());
                    service.remove(taskId);
                    break;


            }

        }
    }

    /////////////////////////////////////////////////////////
    private static void caseOneMenu (int T)
    {
       // Scanner scanner2 = new Scanner(System.in);
        System.out.println("1 - list all task for today");
        System.out.println("2 - list all work task ");
        System.out.println("3 - list all personal task");
        System.out.println("4 - exit");
        System.out.println("Введите число:");
        T =  Integer.parseInt(scanner.nextLine());
        if (T == 4) {
            System.exit(0);
        }


        switch (T) {
            case 1:
                System.out.println("//////////////////////////////////////////////////////////");
                System.out.println("Задачи на сегодня: ");
                System.out.println("Задачи отсуствуют");
                System.out.println("//////////////////////////////////////////////////////////");

                // list.showByValue(valueDate);
                break;
            case 2:
                System.out.println("Добавим задачу:");
                break;
            case 3:
                break;

        }
    }
    private enum TaskPeriod {
        ONE (OneTimeTask::new),
        DAILY (DailyTask::new),
        WEEKLY (WeeklyTask::new),
        MONTHLY (MonthlyTask::new),
        YEARLY (YearlyTask::new);
        private final BiFunction<Type, LocalDateTime,  Task> function;

        TaskPeriod(BiFunction<Type, LocalDateTime, Task> function) {
            this.function = function;

    }
        public Task getTask(LocalDateTime date, Type type) {
            return function.apply(type, date);
        }
    }
    private static void addNewTask() {
        System.out.println("give the task a name:");
        var title = scanner.nextLine();
        System.out.println("give the task a description:");
        var description = scanner.nextLine();
        System.out.println("enter the date task format 2023-02-11:");
        LocalDate localDate;
        String dateString;
        dateString = scanner.nextLine();
        try{
            localDate = LocalDate.parse(dateString);

        }catch (DateTimeParseException z){
            throw new IncorrectArgumentException(dateString);
        }
        System.out.println("Enter the task type: " + Arrays.toString(Type.values()));
        var typeString = scanner.nextLine().toUpperCase();
        Type typeEnum = Type.valueOf(typeString);
        System.out.println("enter the task period: "+ Arrays.toString(TaskPeriod.values()));
        var taskPeriod = scanner.nextLine().toUpperCase();
        TaskPeriod taskPeriodEnum = TaskPeriod.valueOf(taskPeriod);
        Task task = taskPeriodEnum.getTask(localDate.atStartOfDay(),typeEnum);
        task.setTitle(title);
        task.setDescription(description);
        service.addTask(task);
    }

//    private void getList (int T){
//        System.out.println("List");
//    }
//    private static void printTestResult(boolean result, boolean expected) {
//        if (result == expected) {
//            System.out.println("Test passed");
//        } else {
//            System.out.println("Test failed");
//        }
//    }
}
