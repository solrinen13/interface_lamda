package SecondCourse_CourseWork.DateTask;

import SecondCourse_CourseWork.Task;
import SecondCourse_CourseWork.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task {

    public OneTimeTask(Type type, LocalDateTime dateTask) {
        super(type, dateTask);
    }

    public OneTimeTask(String title, Type type, LocalDateTime dateTask, String description) {
        super( title, type, dateTask, description);
    }

    @Override
    protected boolean appearsIn(LocalDate E) {
        return true;
    }
}
