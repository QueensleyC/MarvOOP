public class MathsStudents extends Students{
    private static final double QUIZ_AVERAGE = 0.15; //Average of 5 scores
    private static final double TEST1 = 0.25;
    private static final double TEST2 = 0.25;
    private static final double FINAL_EXAM = 0.35;

    private final double quiz1;
    private final double quiz2;
    private final double quiz3;
    private final double quiz4;
    private final double quiz5;
    private final int test1;
    private final int test2;
    private final int finalExamScore;

    public MathsStudents(String firstName, String lastName, String courseOfStudy, double quiz1, double quiz2, double quiz3, double quiz4, double quiz5, int test1, int test2, int finalExamScore) {
        super(firstName, lastName, courseOfStudy);
        this.quiz1 = quiz1;
        this.quiz2 = quiz2;
        this.quiz3 = quiz3;
        this.quiz4 = quiz4;
        this.quiz5 = quiz5;
        this.test1 = test1;
        this.test2 = test2;
        this.finalExamScore = finalExamScore;
    }

    public double studentFinalAverage(){

        double quiz_average = (quiz1 + quiz2 + quiz3 + quiz4 + quiz5)/5;

        return (QUIZ_AVERAGE * quiz_average) + (TEST1 * test1) + (TEST2 * test2) + (FINAL_EXAM * finalExamScore);
    }

    public int getFinalExamScore() {
        return finalExamScore;
    }


}
