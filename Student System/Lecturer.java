import java.util.ArrayList;
import java.util.List;

public class Lecturer extends Person {
    private String lecId;
    private String programme;
    private Course[] courses;

    public Lecturer(String lecId, String programme, String name, int age){
        super(name, age);
        this.lecId = lecId;
        this.courses = new Course[0];
        this.programme = programme;
    }
    public void allocateCourse(Course course){
        Course[] newCourses = new Course[courses.length + 1];
        for (int i = 0; i < courses.length; i++) {
            newCourses[i] = courses[i];
        }
        newCourses[courses.length] = course;
        courses = newCourses;

    }
    public List<String> getCourses() {
        List<String> courseNames = new ArrayList<String>();
        for (Course course : courses) {
            courseNames.add(course.getTitle());
        }
        return courseNames;
    }

}
