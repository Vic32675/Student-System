import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Lecturer extends JFrame {
    private Person person;
    private String lecId;
    private String programme;
    private Course[] courses;
    private JPanel viewLecturerPanel;
    private JLabel yourLecturersLabel;
    public Lecturer(){
        setTitle("Lecturers");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        viewLecturerPanel = new JPanel();
        viewLecturerPanel.setLayout(new BoxLayout(viewLecturerPanel, BoxLayout.Y_AXIS));

        yourLecturersLabel = new JLabel("Your Lecturers");
        viewLecturerPanel.add(yourLecturersLabel);


    }
    public Lecturer(String lecId, String programme, String name, int age){
        this.person = new Person(name, age);
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
