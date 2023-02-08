package SecondCourse_CourseWork.DateTask;

import SecondCourse_CourseWork.Task;

import java.time.LocalDate;

public class OneTimeTask extends Task {

    @Override
    protected boolean appearsIn(LocalDate E) {
        return true;
    }
}
