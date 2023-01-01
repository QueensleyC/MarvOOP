public class HistoryStudents extends Students {

    private static final double ATTENDANCE = 0.10;
    private static final double PROJECT = 0.30;
    private static final double MIDTERM = 0.30;
    private static final double FINAL_EXAM = 0.30;

    private final int attendanceScore;
    private final int projectScore;
    private final int midtermScore;
    private final int finalExamScore;

    public HistoryStudents(String firstName, String lastName, String courseOfStudy, int attendanceScore, int projectScore, int midtermScore, int finalExamScore) {
        super(firstName, lastName, courseOfStudy);
        this.attendanceScore = attendanceScore;
        this.projectScore = projectScore;
        this.midtermScore = midtermScore;
        this.finalExamScore = finalExamScore;
    }

    public double studentFinalAverage(){
        return (ATTENDANCE * attendanceScore) + (PROJECT * projectScore) + (MIDTERM * midtermScore) + (FINAL_EXAM * finalExamScore);
    }

    public int getFinalExamScore() {
        return finalExamScore;
    }
}
