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
    public boolean appearsIn(LocalDate E) {


            if( E.lengthOfMonth() < getDateTask().toLocalDate().lengthOfMonth() && E.lengthOfMonth() < getDateTask().getDayOfMonth()){
                return E.isAfter(getDateTask().toLocalDate()) && E.getDayOfMonth() == E.lengthOfMonth() ;
            }else
        return E.isAfter(getDateTask().toLocalDate()) && E.getDayOfMonth() == getDateTask().getDayOfMonth() || E.isEqual(getDateTask().toLocalDate());
    }

}