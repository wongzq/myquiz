
import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class FileReadWrite {

    private static File myf = new File("./data", "applicants.txt");

    public static ApplicantAnswer[] readExamAnsTxt() {

        ApplicantAnswer[] appAns = {};
        return appAns;
    }

    public static void writeExamAnsTxt(ApplicantAnswer ans) {

    }

    public static LinkedList<Applicant> readAppTxt() {

        LinkedList<Applicant> app = new LinkedList<Applicant>();
        Scanner fileScanner , lineScanner;
        String username;
        String password;
        int totApplicants;
        
        
        try {
            fileScanner = new Scanner(myf);
            String numOfLines = fileScanner.nextLine();
            totApplicants = Integer.parseInt(numOfLines); 
            for(int k = 0; k < totApplicants; k++){
              String first = fileScanner.nextLine();
              System.out.println(first);
              lineScanner = new Scanner(first);
              lineScanner.useDelimiter(":");
              username = lineScanner.next();
              password = lineScanner.next();
              Applicant ap1 = new Applicant(username, password);
              app.add(ap1);
            }
     
        } catch (FileNotFoundException e) {

        }

        return app;
    }

    public static Question[] readQuesAnsTxt() { //basically hwo to print out the exam paper 
        Question[] quesAns = {};
        return quesAns;
    }
    
}
