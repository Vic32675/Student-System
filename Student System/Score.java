public class Score {
    private int cat;
    private int exam;
    private  String grade;

    public Score(int exam, int cat){
        this.exam = exam;
        this.cat = cat;
        this.grade = getGrade();
    }

    public Score() {
        this.exam = getExam();
        this.cat = getCat();

    }

    public int getCat(){

        return cat;
    }

    public int getExam() {

        return exam;
    }
    public int getAverage(){

        return (cat+exam);
    }
    public String getGrade(){
        int total = getAverage();
        if (total>=70){
            return "A";
        }
        else if (total >= 60 && total < 70){
            return "B";

        }
        else if (total >= 50 && total < 60){
            return "C";
        } else if (total >= 40 && total < 50) {
            return "D";
        } else {
            return "Fail";

        }
    }
}
