package SecondCourse_CourseWork.DateTask;

import SecondCourse_CourseWork.Task;

import java.time.LocalDate;

public class MonthlyTask extends Task {


    public MonthlyTask(LocalDate lDate) {
    }

    @Override
    public boolean appearsIn(LocalDate E) {


//        if (E.lengthOfMonth() >= getDateTask().toLocalDate().lengthOfMonth()) {
//
//            return E.isAfter(getDateTask().toLocalDate()) && E.getDayOfMonth() == getDateTask().getDayOfMonth();
//        }else
            if( E.lengthOfMonth() < getDateTask().toLocalDate().lengthOfMonth() && E.lengthOfMonth() < getDateTask().getDayOfMonth()){
                return E.isAfter(getDateTask().toLocalDate()) && E.getDayOfMonth() == E.lengthOfMonth() ;
            }

        return E.isAfter(getDateTask().toLocalDate()) && E.getDayOfMonth() == getDateTask().getDayOfMonth();
    }

}