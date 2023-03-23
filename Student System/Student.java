import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends Person {
    private String regNo;
    private String programme;
    private List<Course> courses;
    private Map<Course, Score> scores;

    //student constructor

    public Student(String name, int age, String regNo, String programme){
        super(name, age);
        this.regNo = regNo;
        this.programme = programme;
        this.courses = new ArrayList<>();
        this.scores = new HashMap<>();

    }

    public String getRegNo(){

        return regNo;

    }
    public String getProgramme(){
        return programme;
    }
    public void allocateCourse(Course course){
        if (courses.size() < 5) {
            courses.add(course);
            course.addStudent(this);
            scores.put(course, new Score());
        } else {
            System.out.println("You have already enrolled in the maximum number of courses.");
        }
    }

    public List<Course> getCourses(){

        return courses;
    }
    public Score getCourseScore(Course course){

        // Check if the student is enrolled in the specified course
        if (!courses.contains(course)) {
            throw new IllegalArgumentException("Student not enrolled in course.");
        }

        // Retrieve the score associated with  course
        Score score = scores.get(course);

        // If the score object doesn't exist, create a default one with 0 marks
        if (score == null) {
            score = new Score();
        }

        return score;
    }
    public String[][] getResult(){

        return getResult();
    }

}
