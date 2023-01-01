import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class GradeCalculator {

    public static void main(String[] args) {
        List<String> dataFromFile;

        System.out.println("Enter the Input file name: ");
        Scanner in = new Scanner(System.in);
        String inputFileName = in.next();

        System.out.println("Enter the Output file name: ");
        String outputFileName = in.next();

        // Read data from input file
        try {

            if (inputFileName.endsWith(".txt")) {
                dataFromFile = Files.readAllLines(Paths.get(inputFileName), StandardCharsets.UTF_8);

            } else {
                dataFromFile = Files.readAllLines(Paths.get(inputFileName + ".txt"), StandardCharsets.UTF_8);

            }

            // Store students' data using a list of lists
            List<List<String>> listOfLists = new ArrayList<>();
            List<String> innerList = new ArrayList<>();
            for (int i = 0; i < dataFromFile.size(); i++) {

                if (i % 2 != 0) {
                    innerList = List.of(dataFromFile.get(i) + ", " + dataFromFile.get(i + 1));
                    listOfLists.add(innerList);
                }
            }

            String[] studentsList = new String[listOfLists.size()];

            //Storing student data in their respective objects
            Students[] students = new Students[listOfLists.size()];
            List<EnglishStudents> englishStudents = new ArrayList<>();
            List<MathsStudents> mathsStudents = new ArrayList<>();
            List<HistoryStudents> historyStudents = new ArrayList<>();

            for (int i = 0; i < studentsList.length; i++) {
                studentsList[i] = listOfLists.get(i).get(0);

                for (int j = 0; j < 1; j++) {
                    String[] studentDetails = studentsList[i].split(", ");
                    students[i] = new Students(studentDetails[1], studentDetails[0], studentDetails[2].split(" ")[0]);

                    String scores = studentDetails[2].split(" ", 2)[1]; //Get only scores from input

                    switch (students[i].getCourseOfStudy()) {
                        case "English" -> {
                            String[] values = scores.split(" ");
                            englishStudents.add(new EnglishStudents(students[i].getFirstName(), students[i].getLastName(), students[i].getCourseOfStudy(),
                                    Integer.parseInt(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2])));
                        }
                        case "Math" -> mathsStudents.add(new MathsStudents(students[i].getFirstName(), students[i].getLastName(), students[i].getCourseOfStudy(),
                                Double.parseDouble(scores.split(" ")[0]),
                                Double.parseDouble(scores.split(" ")[1]),
                                (Double.parseDouble(scores.split(" ")[2])),
                                (Double.parseDouble(scores.split(" ")[3])),
                                (Double.parseDouble(scores.split(" ")[4])),
                                Integer.parseInt(scores.split(" ")[5]),
                                Integer.parseInt(scores.split(" ")[6]),
                                Integer.parseInt(scores.split(" ")[7])));
                        case "History" -> {
                            String[] values = scores.split(" ");
                            historyStudents.add(new HistoryStudents(students[i].getFirstName(), students[i].getLastName(), students[i].getCourseOfStudy(),
                                    Integer.parseInt(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2]), Integer.parseInt(values[3])));
                        }
                    }

                }

            }

            // Printing output to a file
            printsOutput(outputFileName, englishStudents, historyStudents, mathsStudents);

            // Cleaning up allocated spaces
            listOfLists.clear();
            dataFromFile.clear();
            englishStudents.clear();
            historyStudents.clear();
            mathsStudents.clear();


        } catch (IOException e) {
            System.out.println(e);
        }


    }

    public static void printsOutput(String filename, List<EnglishStudents> englishStudents, List<HistoryStudents> historyStudents, List<MathsStudents> mathsStudents) throws IOException {
        FileWriter fileWriter; // Object for writing to file

        if (filename.endsWith(".txt")) {
            fileWriter = new FileWriter(filename);

        } else {
            fileWriter = new FileWriter(filename + ".txt");

        }

        final DecimalFormat df = new DecimalFormat("0.00");

        df.setRoundingMode(RoundingMode.UP); // Round up final average to 2 decimal places

        List<String> letterGrades = new ArrayList<>();

        System.out.println();

        fileWriter.write("Student Grade Summary\n");

        fileWriter.write("---------------------\n");


        fileWriter.write("\n");
        fileWriter.write("ENGLISH CLASS\n\n");

        fileWriter.write(String.format("%-30s %10s %10s %10s \n", "STUDENT", "FINAL", "FINAL", "LETTER"));
        fileWriter.write(String.format("%-30s %9s %9s %11s \n", "NAME", "EXAM", "AVG", "GRADE"));

        fileWriter.write("----------------------------------------------------------------\n");

        for (EnglishStudents e : englishStudents) {
            fileWriter.write(String.format("%-30s %9s %9s %11s \n",
                    e.getFirstName() + " " + e.getLastName(),
                    e.getFinalExamScore(),
                    df.format(e.studentFinalAverage()),
                    e.letterGrade(Double.parseDouble(df.format(e.studentFinalAverage())))));
            letterGrades.add(e.letterGrade(Double.parseDouble(df.format(e.studentFinalAverage()))));
        }

        System.out.println();
        System.out.println();

        fileWriter.write("\n\nHISTORY CLASS\n\n");

        fileWriter.write(String.format("%-30s %10s %10s %10s \n", "STUDENT", "FINAL", "FINAL", "LETTER"));
        fileWriter.write(String.format("%-30s %9s %9s %11s \n", "NAME", "EXAM", "AVG", "GRADE"));

        fileWriter.write("----------------------------------------------------------------\n");
        for (HistoryStudents h : historyStudents) {
            fileWriter.write(String.format("%-30s %9s %9s %11s \n",
                    h.getFirstName() + " " + h.getLastName(),
                    h.getFinalExamScore(),
                    df.format(h.studentFinalAverage()),
                    h.letterGrade(Double.parseDouble(df.format(h.studentFinalAverage())))
            ));
            letterGrades.add(h.letterGrade(Double.parseDouble(df.format(h.studentFinalAverage()))));
        }


        fileWriter.write("\n\nMATHS CLASS\n\n");

        fileWriter.write(String.format("%-30s %10s %10s %10s \n", "STUDENT", "FINAL", "FINAL", "LETTER"));
        fileWriter.write(String.format("%-30s %9s %9s %11s \n", "NAME", "EXAM", "AVG", "GRADE"));

        fileWriter.write("----------------------------------------------------------------\n");
        for (MathsStudents m : mathsStudents) {
            fileWriter.write(String.format("%-30s %9s %9s %11s \n",
                    m.getFirstName() + " " + m.getLastName(),
                    m.getFinalExamScore(),
                    df.format(m.studentFinalAverage()),
                    m.letterGrade(Double.parseDouble(df.format(m.studentFinalAverage())))
            ));
            letterGrades.add(m.letterGrade(Double.parseDouble(df.format(m.studentFinalAverage()))));
        }

        fileWriter.write("\n\nOVERALL GRADE DISTRIBUTION\n\n");

        fileWriter.write("A: " + Collections.frequency(letterGrades, "A"));
        fileWriter.write("\nB: " + Collections.frequency(letterGrades, "B"));
        fileWriter.write("\nC: " + Collections.frequency(letterGrades, "C"));
        fileWriter.write("\nD: " + Collections.frequency(letterGrades, "D"));
        fileWriter.write("\nE: " + Collections.frequency(letterGrades, "E"));
        fileWriter.write("\nF: " + Collections.frequency(letterGrades, "F"));

        fileWriter.close();

        if (filename.endsWith(".txt")) {
            System.out.println("Summary report successfully written to " + filename);


        } else {
            System.out.println("Summary report successfully written to " + filename + ".txt");

        }

    }

}
