
import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWrite {

    private static File applicantTxt = new File("./data", "applicants.txt");
    private static File questionsTxt = new File("./data", "questions.txt");
    private static File examAnsTxt = new File("./data", "exam_answers.txt");

    public static LinkedList<ApplicantAnswer> readExamAnsTxt() {

        LinkedList<ApplicantAnswer> app = new LinkedList<>();
        Scanner fileScanner, lineScanner;
        try {
            fileScanner = new Scanner(examAnsTxt);

            while (fileScanner.hasNextLine()) {
                String first = fileScanner.nextLine();
                System.out.println(first);

                lineScanner = new Scanner(first);
                lineScanner.useDelimiter(":");
                String name = lineScanner.next();
                int age = Integer.parseInt(lineScanner.next());
                String gender = lineScanner.next();
                String nationality = lineScanner.next();
                String appClass = lineScanner.next();
                String appID = lineScanner.next();
                String course = lineScanner.next();

                ApplicantDetails appDetails = new ApplicantDetails(name, "", age, gender, nationality, appClass, appID, course);
                char[] answers = new char[20];
                for (int i = 0; i < 20; i++) {
                    answers[i] = lineScanner.next().charAt(0);
                }
                lineScanner.close();

                ApplicantAnswer appAns = new ApplicantAnswer(answers, appDetails);
                app.add(appAns);
            }
            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File to read " + applicantTxt + " not found!");
        }

        return app;

    }

    public static void writeExamAnsTxt(ApplicantAnswer ans) {
        try {
            char ansList[] = ans.getAnswers();
            PrintWriter pw = new PrintWriter(new FileWriter(examAnsTxt, true));
            pw.print(ans.getApplicant().getName() + ":"
                    + ans.getApplicant().getAge() + ":"
                    + ans.getApplicant().getGender() + ":"
                    + ans.getApplicant().getNationality() + ":"
                    + ans.getApplicant().getAppClass() + ":"
                    + ans.getApplicant().getID() + ":"
                    + ans.getApplicant().getCourse() + ":"
            );
            for (int i = 0; i < ansList.length; i++) {
                pw.print(ansList[i] + ":");
            }
            pw.println();
            pw.close();
        } catch (IOException e) {
            System.out.println("MY ERROR : " + e);
        }

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

    public static Question[] readQuesAnsTxt() { //basically how to print out the exam paper 
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

    public static char[] readCorrectAnswers() {
        char[] correctAns = new char[20];
        LinkedList<Question> questions = FileReadWrite.readQuesTxt();
        for (int i = 0; i < questions.size(); i++) {
            correctAns[i] = questions.get(i).getCorrectAns();
        }
        return correctAns;
    }

}
