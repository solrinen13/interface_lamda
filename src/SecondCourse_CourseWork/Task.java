package SecondCourse_CourseWork;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    private static int idGenerator = 0;
    private String title;
    private final Type type;
    private int id;
    private LocalDateTime dateTask;
    private String description;


    public Task(Type type, LocalDateTime dateTask) {
        this.id = ++idGenerator;
        this.type = type;
        this.dateTask = dateTask;
    }

    public Task(String title, Type type, LocalDateTime dateTask, String description) {

        this.id = ++idGenerator;
        this.title = title;
        this.type = type;
        this.dateTask = dateTask;
        this.description = description;
    }

    //throws
    protected abstract boolean appearsIn(LocalDate E);

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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && type == task.type && Objects.equals(dateTask, task.dateTask) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, id, dateTask, description);
    }


    @Override
    public String toString() {
        return this.getId() + " " + this.getType() + " " + this.getTitle() + " " + this.getDescription();
    }
}
