
import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FileReadWrite {

    private static File applicantTxt = new File("./data", "applicants.txt");
    private static File questionsTxt = new File("./data", "questions.txt");

    public static ApplicantAnswer[] readExamAnsTxt() {

        ApplicantAnswer[] appAns = {};
        return appAns;
    }

    public static void writeExamAnsTxt(ApplicantAnswer ans) {

    }

    public static LinkedList<Applicant> readAppTxt() {

        LinkedList<Applicant> app = new LinkedList<Applicant>();
        Scanner fileScanner, lineScanner;
        String username;
        String password;
        int totApplicants;

        try {
            fileScanner = new Scanner(applicantTxt);
            String numOfLines = fileScanner.nextLine();
            totApplicants = Integer.parseInt(numOfLines);
            for (int k = 0; k < totApplicants; k++) {
                String first = fileScanner.nextLine();
                lineScanner = new Scanner(first);
                lineScanner.useDelimiter(":");
                username = lineScanner.next();
                password = lineScanner.next();
                Applicant ap1 = new Applicant(username, password);
                app.add(ap1);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File to read " + applicantTxt + " not found!");
        }

        return app;
    }

    public static Question[] readQuesAnsTxt() { //basically hwo to print out the exam paper 
        Question[] quesAns = {};
        return quesAns;
    }

    public static LinkedList<Question> readQuesTxt() {

        LinkedList<Question> ques = new LinkedList<Question>();
        Scanner fileScanner, lineScanner;

        int totQues;

        try {
            fileScanner = new Scanner(questionsTxt);
            String numOfLines = fileScanner.nextLine();
            totQues = Integer.parseInt(numOfLines);

            for (int k = 1; k <= totQues; k++) {
                String first = fileScanner.nextLine();
                lineScanner = new Scanner(first);
                lineScanner.useDelimiter(":");

                int type = Integer.parseInt(lineScanner.next());
                char answer = lineScanner.next().charAt(0);
                switch (type) {
                    case 1:
                        String question1 = lineScanner.next();

                        Answer[] a1 = new Answer[4];
                        a1[0] = new Answer(lineScanner.next(), "");
                        a1[1] = new Answer(lineScanner.next(), "");
                        a1[2] = new Answer(lineScanner.next(), "");
                        a1[3] = new Answer(lineScanner.next(), "");

                        Question q1 = new Question(question1, "", a1, answer, 1);
                        ques.add(q1);
                        break;

                    case 2:
                        String question2 = lineScanner.next();
                        String q2image = lineScanner.next();

                        Answer[] a2 = new Answer[4];
                        a2[0] = new Answer(lineScanner.next(), "");
                        a2[1] = new Answer(lineScanner.next(), "");
                        a2[2] = new Answer(lineScanner.next(), "");
                        a2[3] = new Answer(lineScanner.next(), "");

                        Question q2 = new Question(question2, q2image, a2, answer, 2);
                        ques.add(q2);
                        break;

                    case 3:
                        String question3 = lineScanner.next();

                        Answer[] a3 = new Answer[4];
                        a3[0] = new Answer("", lineScanner.next());
                        a3[1] = new Answer("", lineScanner.next());
                        a3[2] = new Answer("", lineScanner.next());
                        a3[3] = new Answer("", lineScanner.next());

                        Question q3 = new Question(question3, "", a3, answer, 3);
                        ques.add(q3);
                        break;
                }

            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File to read " + questionsTxt + " not found!");
        }

        return ques;
    }

}
