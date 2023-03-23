public class Book {
    private String isnn;
    private String title;
    private String edition;
    private String version;
    private int yearPublished;
    private int totalCopies;
    private int borrowedCopies;

    public Book(String isnn, String title, String edition, String version, int yearPublished, int totalCopies, int borrowedCopies) {
        this.isnn = isnn;
        this.title = title;
        this.edition = edition;
        this.version = version;
        this.yearPublished = yearPublished;
        this.totalCopies = totalCopies;
        this.borrowedCopies = borrowedCopies;
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

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getBorrowedCopies() {
        return borrowedCopies;
    }

    public void borrowBook() {
        if (borrowedCopies < totalCopies) {
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
