package SecondCourse_CourseWork.DateTask;

import SecondCourse_CourseWork.Task;
import SecondCourse_CourseWork.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {

    public MonthlyTask(Type type, LocalDateTime dateTask) {
        super(type, dateTask);
    }

    public MonthlyTask(String title, Type type, LocalDateTime dateTask, String description) {
        super(title, type, dateTask, description);
    }

    @Override
    public boolean appearsIn(LocalDate e) {


        if (e.lengthOfMonth() < getDateTask().toLocalDate().lengthOfMonth() && e.lengthOfMonth() < getDateTask().getDayOfMonth()) {
            return e.isAfter(getDateTask().toLocalDate()) && e.getDayOfMonth() == e.lengthOfMonth();
        } else
            return e.isAfter(getDateTask().toLocalDate()) && e.getDayOfMonth() == getDateTask().getDayOfMonth() || e.isEqual(getDateTask().toLocalDate());
    }

}