package SecondCourse_CourseWork.DateTask;

import SecondCourse_CourseWork.Task;
import SecondCourse_CourseWork.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {

    public DailyTask(Type type, LocalDateTime dateTask) {
        super(type, dateTask);
    }

    public DailyTask(String title, Type type, LocalDateTime dateTask, String description) {
        super( title, type, dateTask, description);
    }

    @Override
    protected boolean appearsIn(LocalDate e) {

       // return e.isAfter(getDateTask().toLocalDate()) || e.isEqual(getDateTask().toLocalDate());
        return true;
    }
}
