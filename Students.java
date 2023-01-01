public class Students {
    //TODO: set character limit for name to 200 or less


    private final String firstName;
    private final String lastName;
    private final String courseOfStudy;

    public Students(String firstName, String lastName, String courseOfStudy) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.courseOfStudy = courseOfStudy;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCourseOfStudy() {
        return courseOfStudy;
    }

    public String letterGrade(double finalScore){
        if(finalScore >= 90){
            return "A";
        } else if(finalScore >= 80 && finalScore <=89){
            return  "B";
        } else if(finalScore >= 70 && finalScore <=79){
            return  "C";
        } else if(finalScore >= 60 && finalScore <=69){
            return  "D";
        } else if(finalScore >= 50 && finalScore <=59){
            return  "E";
        } else {
            return  "F";
        }
    }

    @Override
    public String toString() {
        return "Students{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", courseOfStudy='" + courseOfStudy + '\'' +
                '}';
    }
}
