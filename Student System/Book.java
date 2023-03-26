import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;


public class Book extends JFrame{
    private JPanel bookPanel;
    private JLabel titleLabel;
    private JTextField titleField;
    private JLabel authorLabel;
    private JTextField authorField;
    private JLabel editionLabel;
    private JTextField editionField;

    private JLabel versionLabel;
    private JTextField versionField;

    private JLabel yearLabel;
    private JTextField yearField;
    private JLabel availableLabel;
    private JTextField availableField;
    private JLabel borrowedLabel;
    private JTextField borrowedField;
    private JButton borrowButton;
    private JButton returnButton;
    private JTextField searchField;
    private JButton searchButton;

    public Book(){
        setTitle("Book Library");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        bookPanel = new JPanel();
        bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.Y_AXIS));

        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        searchButton.setIcon(new ImageIcon("Icons/search.png"));
        bookPanel.add(searchField);
        bookPanel.add(searchButton);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == searchButton) {
                    String searchTitle = searchField.getText();
                    Book foundBook = searchBookByTitle(searchTitle);
                    if (foundBook == null) {
                        JOptionPane.showMessageDialog(Book.this, "Book not found");

                    } else {
                        titleField.setText(foundBook.getTitle());
                        editionField.setText(foundBook.getEdition());
                        versionField.setText(foundBook.getVersion());
                        yearField.setText(Integer.toString(foundBook.getYearPublished()));
                        availableField.setText(Integer.toString(foundBook.getAvailableCopies()));
                        borrowedField.setText(Integer.toString(foundBook.getBorrowedCopies()));
                    }
                }
            }
        });

        titleLabel = new JLabel("Title:");
        titleLabel.setIcon(new ImageIcon("Icons/title.png"));
        titleField = new JTextField(50);
        bookPanel.add(titleLabel);
        bookPanel.add(titleField);

        authorLabel = new JLabel("Author:");
        authorLabel.setIcon(new ImageIcon("Icons/author.png"));
        authorField = new JTextField(50);
        bookPanel.add(authorLabel);
        bookPanel.add(authorField);

        editionLabel = new JLabel("Edition");
        editionLabel.setIcon(new ImageIcon("Icons/edition.png"));
        editionField = new JTextField(20);
        bookPanel.add(editionLabel);
        bookPanel.add(editionField);

        versionLabel = new JLabel("Version:");
        versionLabel.setIcon(new ImageIcon("Icons/version.png"));
        versionField = new JTextField(20);
        bookPanel.add(versionLabel);
        bookPanel.add(versionField);

        yearLabel = new JLabel("Year:");
        yearLabel.setIcon(new ImageIcon("Icons/year.png"));
        yearField = new JTextField(4);
        bookPanel.add(yearLabel);
        bookPanel.add(yearField);

        availableLabel = new JLabel("Availability");
        availableLabel.setIcon(new ImageIcon("Icons/available.png"));
        availableField = new JTextField(10);
        bookPanel.add(availableLabel);
        bookPanel.add(availableField);

        borrowedLabel = new JLabel("Borrowed Status");
        borrowedLabel.setIcon(new ImageIcon("Icons/borrow.png"));
        borrowedField = new JTextField(10);
        bookPanel.add(borrowedLabel);
        bookPanel.add(borrowedField);

        borrowButton = new JButton("Borrow");
        bookPanel.add(borrowButton);
        borrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == borrowButton){
                    if (availableCopies == 0){
                        JOptionPane.showMessageDialog( bookPanel, "No copies available");
                    }else {
                        availableCopies--;
                        borrowedCopies++;
                        updateFields();
                        JOptionPane.showMessageDialog(bookPanel, "Book borrowed successfully");
                    }
                }
            }
        });

        returnButton = new JButton("Return");
        bookPanel.add(returnButton);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == returnButton) {

                    if (borrowedCopies == 0){
                        JOptionPane.showMessageDialog(bookPanel,"No copies Borrowed");
                    }else {
                        availableCopies++;
                        borrowedCopies--;
                        updateFields();
                        JOptionPane.showMessageDialog(bookPanel, "Book returned successfully");

                    }

                }
            }
        });

    add(bookPanel);
    pack();
    setVisible(true);

    }
    public void updateFields(){
        titleField.setText(title);
        authorField.setText(isnn);;
        editionField.setText(edition);
        versionField.setText(version);
        yearField.setText(Integer.toString(yearPublished));
        availableField.setText(Integer.toString(availableCopies));
        borrowedField.setText(Integer.toString(borrowedCopies));
    }
    public Book searchBookByTitle(String title) {

        for (Book book : books) {
            if (book.getTitle().equals(title)) {

                return book;
            }
        }

        return null;
    }

    private String isnn;
    private String title;
    private String edition;
    private String version;
    private int yearPublished;
    private int availableCopies;
    private int totalCopies;
    private int borrowedCopies;
    private List<Book> books;

    public Book(String isnn, String title, String edition, String version, int yearPublished, int availableCopies, int borrowedCopies) {
        this.isnn = isnn;
        this.title = title;
        this.edition = edition;
        this.version = version;
        this.yearPublished = yearPublished;
        this.availableCopies = availableCopies = 0;
        this.totalCopies = totalCopies;
        this.borrowedCopies = borrowedCopies = 0;
    }

    public String getIsnn() {
        return isnn;
    }

    public String getTitle() {
        return title;
    }

    public String getEdition() {
        return edition;
    }

    public String getVersion() {
        return version;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }
    public int getTotalCopies(){
        return totalCopies;
    }

    public int getBorrowedCopies() {
        return borrowedCopies;
    }

    public void borrowBook() {
        if (borrowedCopies < availableCopies) {
            borrowedCopies++;
            System.out.println("Book has been borrowed.");
        } else {
            System.out.println("All copies of this book are currently borrowed.");
        }
    }

    public void returnBook() {
        if (borrowedCopies > 0) {
            borrowedCopies--;
            System.out.println("Book has been returned.");
        } else {
            System.out.println("No copies of this book are currently borrowed.");
        }
    }
}
