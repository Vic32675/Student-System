import javax.swing.*;

public class Homepage extends JFrame {
    private JPanel homePanel;
    private JButton viewCourses;
    private JButton viewBooks;
    private JButton viewLecturer;
    private JButton studentDetails;

    public Homepage(){
        setTitle("Homepage");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        homePanel = new JPanel();
        homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.Y_AXIS));

        studentDetails = new JButton("Your Details");
        homePanel.add(studentDetails);

        viewCourses = new JButton("View Courses");
        homePanel.add(viewCourses);
        viewCourses.addActionListener(e -> {
            Course coursewindow = new Course();
            coursewindow.setVisible(true);
        });

        viewBooks = new JButton("View Library");
        homePanel.add(viewBooks);

        viewLecturer = new JButton("Lectures");
        homePanel.add(viewLecturer);
        viewLecturer.addActionListener(e -> {
            Lecturer lecturerwindow = new Lecturer();
            lecturerwindow.setVisible(true);
        });

        add(homePanel);
        pack();
        setVisible(true);
    }

}
