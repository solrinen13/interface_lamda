package SecondCourse_CourseWork.DateTask;

import SecondCourse_CourseWork.Task;

import java.time.LocalDate;

public class WeeklyTask extends Task {
    @Override
    protected boolean appearsIn(LocalDate E) {

        return E.isAfter(getDateTask().toLocalDate()) && E.getDayOfWeek().equals(getDateTask().getDayOfWeek()) ;
    }
}
