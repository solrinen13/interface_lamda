package SecondCourse_CourseWork;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Task {
    private static int idGenerator = 0;
   private String title;
    private Type type;
    private int id;
    private LocalDateTime dateTask;
    private String description;

//throws
    protected abstract boolean appearsIn (LocalDate E );

    public String getTitle() {
        return title;
    }

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTask() {
        return dateTask;
    }

    public String getDescription() {
        return description;
    }
}
