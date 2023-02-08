package SecondCourse_CourseWork;

import SecondCourse_CourseWork.DateTask.MonthlyTask;

import java.time.LocalDate;
import java.util.Scanner;

public class TaskApp {

    TaskService service = new TaskService();

    public static  void main(String[] args) {
     /*   LocalDate dateTime = LocalDate.parse("2014-01-01");
        System.out.println(dateTime);*/
        int takenValue = 0;
        int valueDate  = 0;
        Scanner scanner =   new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);


       // takenValue = scanner.nextInt();

        var lDate = LocalDate.parse("2020-02-29");
        var task = new MonthlyTask(lDate);

        printTestResult(task.appearsIn(LocalDate.parse("2020-01-01")), false); //date before the task
        printTestResult(task.appearsIn(LocalDate.parse("2020-02-01")), false); //date before the task, yet same month
        printTestResult(task.appearsIn(LocalDate.parse("2020-02-29")), true); //the same date with the task
        printTestResult(task.appearsIn(LocalDate.parse("2020-03-29")), true); //the next date for the task
        printTestResult(task.appearsIn(LocalDate.parse("2020-03-31")), false); //the date at the end of the next month - NEGATIVE CASE
        printTestResult(task.appearsIn(LocalDate.parse("2020-04-29")), true); //the next date for the task
        printTestResult(task.appearsIn(LocalDate.parse("2021-02-28")), true); //one year later, should match




        while (true) {
            System.out.println("1 - check task");
            System.out.println("2 - add task");
            System.out.println("3 - remove task");
            System.out.println("4 - exit");
            System.out.println("Введите число:");
            takenValue = Integer.parseInt(scanner.nextLine());

            if (takenValue == 4) {
                System.exit(0);
            }
            switch (takenValue) {
                case 1:
                    System.out.println("Enter value for search: ");
                    takenValue = 0;
                    caseOneMenu(takenValue);
                   // list.showByValue(valueDate);
                    break;
                case 2:
                    System.out.println("Добавим задачу");
                    break;
                case 3:
                    break;


            }

        }
    }
    private static void caseOneMenu (int T)
    {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("1 - list all task for today");
        System.out.println("2 - list task");
        System.out.println("3 - remove task");
        System.out.println("4 - exit");
        System.out.println("Введите число:");
        T =  Integer.parseInt(scanner2.nextLine());
        if (T == 4) {
            System.exit(0);
        }


        switch (T) {
            case 1:
                System.out.println("//////////////////////////////////////////////////////////");
                System.out.println("Задачи на сегодня: ");

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
    private void getList (int T){
        System.out.println("List");
    }
    private static void printTestResult(boolean result, boolean expected) {
        if (result == expected) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }
}
