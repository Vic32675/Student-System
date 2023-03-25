import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Course extends JFrame {
    private String courseCode;
    private String title;
    private Lecturer lecturer;
    private List<Student> students;
    private List<Score> scores;
    private JPanel viewCoursePanel;
    private  JLabel addCourseLabel;
    private JTextField addCourseField;

    public Course(String courseCode, String title){
        this.courseCode = courseCode;
        this.title = title;
        this.students = new ArrayList<>();
        this.scores = new ArrayList<>();
        lecturer.allocateCourse(this);

    }

    public Course() {
        setTitle("Courses");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        viewCoursePanel = new JPanel();
        viewCoursePanel.setLayout(new BoxLayout(viewCoursePanel, BoxLayout.Y_AXIS));

        addCourseLabel = new JLabel("Add Course");
        viewCoursePanel.add(addCourseLabel);

        addCourseField = new JTextField();
        viewCoursePanel.add(addCourseField);



        add(viewCoursePanel);
        pack();
        setVisible(true);

    }

    public void allocateLecturer(Lecturer lecturer){
        this.lecturer = lecturer;
    }
    public void addStudent(Student student){
        if (students.size() < 30) {
            students.add(student);
        } else {
            System.out.println("This course is already full.");
        }
    }
    public void addScore(Score score) {
        if (scores.size() < students.size()) {
            scores.add(score);
        } else {
            System.out.println("All students in this course already have scores.");
        }
    }
    public List<Student> getStudent(){
        return students;
    }
    public String getCourseCode(){
        return courseCode;
    }
    public String getTitle(){
        return title;
    }
    public Lecturer getLecturer() {
        return lecturer;
    }

    public List<Score> getScores() {
        return scores;
    }


}
