package SecondCourse_CourseWork.AllException;

public class IncorrectArgumentException extends Exception{
    private String argument;
    public IncorrectArgumentException(String argument){
        this.argument = argument;
    }
    public String getArgument(){
        return argument;
    }

    @Override
    public String toString() {
        return "IncorrectArgumentException{" +
                "argument='" + argument + '\'' +
                '}';
    }
}
