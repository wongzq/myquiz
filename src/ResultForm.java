
import java.util.LinkedList;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ResultForm extends Stage {

    private char correctAnswers[] = {'B', 'D', 'A', 'B', 'C', 'B', 'A', 'C', 'A',
        'C', 'D', 'A', 'B', 'D', 'A', 'C', 'C', 'B', 'D', 'A'};
    private LinkedList<ApplicantAnswer> applicantAnswers = new LinkedList<ApplicantAnswer>();

    private LinkedList<Applicant> applicants;
    private ComboBox<Applicant> cmbname;

    private ApplicantAnswer[] answers;

    private NavigateToForm toMyQuiz;
    private NavigateToForm toAnalysisForm;

    private Label labResult = new Label("Result: ");
    private Label labAllAnswer = new Label("");
    private Label labStuAnswer = new Label("");
    private Button btnPass = new Button();

    public ResultForm() {

        applicantAnswers.add(new ApplicantAnswer(
                new char[]{'B', 'C', 'B', 'D', 'A', 'B', 'A', 'C', 'A',
                    'C', 'D', 'A', 'B', 'D', 'A', 'C', 'C', 'B', 'D', 'A'},
                new ApplicantDetails("John Wong",
                        "abc123",
                        20,
                        "Male",
                        "Malaysian",
                        "Class 1",
                        "123",
                        "Computer Science")));

        // ApplicantName
        applicants = FileReadWrite.readAppTxt();

        cmbname = new ComboBox<Applicant>(FXCollections.observableArrayList(applicants));
        Label labName = new Label("Applicant: ");
        labName.setLayoutX(25); // without offset
        labName.setLayoutY(50); // without offset

        cmbname.setLayoutX(150);
        cmbname.setLayoutY(50);
        cmbname.setMinWidth(150);
        cmbname.setMaxWidth(150);
        cmbname.setOnAction(e -> {
            reloadPage();
        });

        // Result
        labResult.setLayoutX(25); // without offset
        labResult.setLayoutY(100); // without offset

        //Pass or Fail
        btnPass.setLayoutX(450);
        btnPass.setLayoutY(25);

        //correct answer: B, C, B, D, A, B, A, C, A, C, D, A, B, D, A, C, C, B, D, A
        //AllAnswer
        labAllAnswer.setLayoutX(25); // without offset
        labAllAnswer.setLayoutY(200); // without offset

        //Student Answer
        labStuAnswer.setLayoutX(25); // without offset
        labStuAnswer.setLayoutY(250);

        //Next
        Button btnNext = new Button();
        btnNext.setLayoutX(50);
        btnNext.setLayoutY(300);
        btnNext.setText("Analysis Form");
        btnNext.setOnAction(e -> {
            toAnalysisForm.navigate();
        });

        //Back
        Button btnBack = new Button();
        btnBack.setLayoutX(150);
        btnBack.setLayoutY(300);
        btnBack.setText("Back to MyQuiz");
        btnBack.setOnAction(e -> {
            toMyQuiz.navigate();
        });

        Pane p1 = new Pane();
        p1.getChildren().add(labName);
        p1.getChildren().add(cmbname);
        p1.getChildren().add(labResult);
        p1.getChildren().add(btnPass);
        p1.getChildren().add(labAllAnswer);
        p1.getChildren().add(labStuAnswer);
        p1.getChildren().add(btnNext);
        p1.getChildren().add(btnBack);

        Scene myScene = new Scene(p1, 600, 400);
        this.setTitle("Result Form");
        this.setScene(myScene);
    }

    public void setToMyQuiz(NavigateToForm toMyQuiz) {
        this.toMyQuiz = toMyQuiz;
    }

    public void setToAnalysisForm(NavigateToForm toAnalysisForm) {
        this.toAnalysisForm = toAnalysisForm;
    }

    private void reloadPage() {
        
        int i = getSelectedIndex();
        if (i == -1) {
            labStuAnswer.setText("");
            btnPass.setText("-");
            labResult.setText("");
            labAllAnswer.setText("");
        } else {
            double result = getResult();
            labResult.setText("Result: " + result + "%");
            labAllAnswer.setText("Correct Answer: " + getArray(correctAnswers));
            labStuAnswer.setText("Student's Answer: " + getArray(applicantAnswers.get(i).getAnswers()));
            if (result < 70) {
                btnPass.setText("Fail");
            } else {
                btnPass.setText("Pass");
            }
        }
    }

    private double getResult() {
        int individualScore = 0;
        int i = getSelectedIndex();
        char ans[] = applicantAnswers.get(i).getAnswers();
        for (int j = 0; j < correctAnswers.length; j++) {
            if (ans[j] == correctAnswers[j]) {
                individualScore++;
            }
        }
        double finalScore = (individualScore / 20f) * 100f;
        return finalScore;
    }

    private int getSelectedIndex() {
        for (int i = 0; i < applicantAnswers.size(); i++) {
            String selectedName = cmbname.getValue().getName();
            String applicantName = applicantAnswers.get(i).getApplicant().getName();
            if (selectedName.equals(applicantName)) {
                return i;

            }
        }
        return -1;
    }

    private String getArray(char[] answers) {
        String readAnswers = "";
        for (int i = 0; i < answers.length; i++) {
            readAnswers = readAnswers + String.valueOf(answers[i]) + " , ";

        }
        return readAnswers;
    }
}

//private void selectStudent() {
//
//}
//
//private void passFail() {
//
//}
