package SecondCourse_CourseWork.DateTask;

import SecondCourse_CourseWork.Task;

import java.time.LocalDate;

public class YearlyTask extends Task {


    @Override
    protected boolean appearsIn(LocalDate E) {
        return E.isAfter(getDateTask().toLocalDate()) && E.getMonth().equals(getDateTask().getMonth())
                && E.getDayOfMonth() == getDateTask().getDayOfMonth();

    }
}
