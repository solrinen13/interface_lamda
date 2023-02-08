package SecondCourse_CourseWork.DateTask;

import SecondCourse_CourseWork.Task;

import java.time.LocalDate;

public class DailyTask extends Task {
    @Override
    protected boolean appearsIn(LocalDate E) {
            return E.isAfter(getDateTask().toLocalDate());
    }
}
