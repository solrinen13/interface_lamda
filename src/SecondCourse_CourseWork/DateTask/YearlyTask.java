package SecondCourse_CourseWork.DateTask;

import SecondCourse_CourseWork.Task;
import SecondCourse_CourseWork.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task {

    public YearlyTask(Type type, LocalDateTime dateTask) {
        super(type, dateTask);
    }

    public YearlyTask(String title, Type type, LocalDateTime dateTask, String description) {
        super( title, type, dateTask, description);
    }

    @Override
    protected boolean appearsIn(LocalDate E) {

        return E.isAfter(getDateTask().toLocalDate()) && E.getMonth().equals(getDateTask().getMonth())
                && E.getDayOfMonth() == getDateTask().getDayOfMonth() || E.isEqual(getDateTask().toLocalDate());

    }
}
