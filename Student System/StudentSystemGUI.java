import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StudentSystemGUI {
    private Connection conn; // database connection
    private JTextField search_field;
    private String searchTerm;

    public StudentSystemGUI() {
        JFrame master = new JFrame("Chuka Uni");

        JLabel title_label = new JLabel("Chuka Student System");
        title_label.setFont(new Font("Arial", Font.BOLD, 24));
        JButton add_student_button = new JButton("Add Student");
        add_student_button.addActionListener(e -> {
            JFrame addStudentFrame = new JFrame("Add Student");

            JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
            panel.add(new JLabel("Registration Number: "));
            JTextField regNoField = new JTextField();
            panel.add(regNoField);
            panel.add(new JLabel("Name: "));
            JTextField nameField = new JTextField();
            panel.add(nameField);
            panel.add(new JLabel("Course: "));
            JTextField courseField = new JTextField();
            panel.add(courseField);
            JButton addStudentButton = new JButton("Add Student");
            addStudentButton.addActionListener(e1 -> {
                String regNo = regNoField.getText();
                String name = nameField.getText();
                String course = courseField.getText();

                // Insert new student record into database
                try {
                    Connection conn = DatabaseConnector.getConnection();
                    PreparedStatement stmt = conn.prepareStatement("INSERT INTO students(reg_no, name, course) VALUES (?, ?, ?)");
                    stmt.setString(1, regNo);
                    stmt.setString(2, name);
                    stmt.setString(3, course);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(addStudentFrame, "Student added successfully.");
                } catch (SQLException e2) {
                    e2.printStackTrace();
                    JOptionPane.showMessageDialog(addStudentFrame, "Error adding student.");
                }
            });
            panel.add(new JLabel());
            panel.add(addStudentButton);

            addStudentFrame.getContentPane().add(panel);
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

            JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
            panel.add(new JLabel("Course Code: "));
            JTextField courseCodeField = new JTextField();
            panel.add(courseCodeField);
            panel.add(new JLabel("Course Name: "));
            JTextField courseNameField = new JTextField();
            panel.add(courseNameField);
            JButton addCourseButton = new JButton("Add Course");
            addCourseButton.addActionListener(e1 -> {
                String courseCode = courseCodeField.getText();
                String courseName = courseNameField.getText();

                // Insert new course record into database
                try {
                    Connection conn = DatabaseConnector.getConnection();
                    PreparedStatement stmt = conn.prepareStatement("INSERT INTO courses(code, name) VALUES (?, ?)");
                    stmt.setString(1, courseCode);
                    stmt.setString(2, courseName);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(addCourseFrame, "Course added successfully.");
                } catch (SQLException e2) {
                    e2.printStackTrace();
                    JOptionPane.showMessageDialog(addCourseFrame, "Error adding course.");
                }
            });
            panel.add(new JLabel());
            panel.add(addCourseButton);

            addCourseFrame.getContentPane().add(panel);
            addCourseFrame.pack();
            addCourseFrame.setVisible(true);
        });
        JButton view_courses_button = new JButton("View Courses");
        view_courses_button.addActionListener(e -> {
            JFrame viewCoursesFrame = new JFrame("View Courses");

            viewCoursesFrame.pack();
            viewCoursesFrame.setVisible(true);
        });
        search_field = new JTextField();
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

        // establish database connection
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_system", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        searchTerm = search_field.getText();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM courses WHERE name LIKE ?");
            stmt.setString(1, "%" + searchTerm + "%");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String courseName = rs.getString("name");
                String courseCode = rs.getString("code");
                JOptionPane.showMessageDialog(null, "Course found: " + courseName + " (" + courseCode + ")");
            } else {
                JOptionPane.showMessageDialog(null, "No courses found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentSystemGUI());
    }
}
