package SecondCourse_CourseWork.AllException;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException (String message){
        super(message);
    }
}
