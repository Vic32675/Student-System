import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentSystemGUI {

    public StudentSystemGUI() {
        JFrame master = new JFrame("Student System");


        JLabel title_label = new JLabel("Student System");
        title_label.setFont(new Font("Arial", Font.BOLD, 24));
        JButton add_student_button = new JButton("Add Student");
        add_student_button.addActionListener(e -> {
            JFrame addStudentFrame = new JFrame("Add Student");

            addStudentFrame.pack();
            addStudentFrame.setVisible(true);
        });
        JButton view_students_button = new JButton("View Students");
        view_students_button.addActionListener(e -> {
            JFrame viewStudentsFrame = new JFrame("View Students");

            viewStudentsFrame.pack();
            viewStudentsFrame.setVisible(true);
        });
        JButton add_course_button = new JButton("Add Course");
        add_course_button.addActionListener(e -> {
            JFrame addCourseFrame = new JFrame("Add Course");

            addCourseFrame.pack();
            addCourseFrame.setVisible(true);
        });
        JButton view_courses_button = new JButton("View Courses");
        view_courses_button.addActionListener(e -> {
            JFrame viewCoursesFrame = new JFrame("View Courses");

            viewCoursesFrame.pack();
            viewCoursesFrame.setVisible(true);
        });
        JTextField search_field = new JTextField();
        JButton search_button = new JButton("Search");
        search_button.addActionListener(e -> handle_search());


        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.add(title_label);
        panel.add(new JLabel());
        panel.add(add_student_button);
        panel.add(view_students_button);
        panel.add(add_course_button);
        panel.add(view_courses_button);
        panel.add(search_field);
        panel.add(search_button);

        master.getContentPane().add(panel);
        master.pack();
        master.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        master.setVisible(true);
    }

    private void handle_add_student() {

    }

    private void handle_view_students() {

    }

    private void handle_add_course() {

    }

    private void handle_view_courses() {

    }

    private void handle_search() {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentSystemGUI());
    }
}
