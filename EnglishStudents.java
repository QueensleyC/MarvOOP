public class EnglishStudents extends Students {

    private static final double TERM_PAPER = 0.25;
    private static final double MIDTERM = 0.35;
    private static final double FINAL_EXAM = 0.40;

    private final int termPaperScore;
    private final int midtermScore;
    private final int finalExamScore;

    public EnglishStudents(String firstName, String lastName, String courseOfStudy, int termPaperScore, int midtermScore, int finalExamScore) {
        super(firstName, lastName, courseOfStudy);
        this.termPaperScore = termPaperScore;
        this.midtermScore = midtermScore;
        this.finalExamScore = finalExamScore;
    }

    public double studentFinalAverage() {
        return (TERM_PAPER * termPaperScore) + (MIDTERM * midtermScore) + (FINAL_EXAM * finalExamScore);
    }

    public int getFinalExamScore() {
        return finalExamScore;
    }

    @Override
    public String toString() {
        return "EnglishStudents{" +
                "Name= " + getFirstName() + ",termPaperScore=" + termPaperScore +
                ", midtermScore=" + midtermScore +
                ", finalExamScore=" + finalExamScore +
                ", finalAverage=" + studentFinalAverage() +
                '}';
    }
}
