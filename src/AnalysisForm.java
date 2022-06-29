import java.util.LinkedList;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AnalysisForm extends Stage {

    
    private LinkedList<Applicant> applicants;
    private ComboBox<Applicant> cmbname;
    
    
    private char correctAnswers[] = {'B', 'D', 'A', 'B', 'C', 'B', 'A', 'C', 'A',
        'C', 'D', 'A', 'B', 'D', 'A', 'C', 'C', 'B', 'D', 'A'};
    private LinkedList<ApplicantAnswer> applicantAnswers = new LinkedList<ApplicantAnswer>();

    private NavigateToForm toMyQuiz;
    private NavigateToForm toResultForm;

    private Label labMax = new Label("Max: ");
    private Label labMin = new Label("Min: ");
    private Label labAvg = new Label("Average: ");

    public AnalysisForm() {
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

        applicantAnswers.add(new ApplicantAnswer(
                new char[]{'B', 'D', 'A', 'B', 'C', 'B', 'A', 'C', 'A',
                    'C', 'D', 'A', 'B', 'D', 'A', 'B', 'C', 'B', 'D', 'A'},
                new ApplicantDetails("Sarah Lee",
                        "def234",
                        20,
                        "Female",
                        "Malaysian",
                        "Class 1",
                        "123",
                        "Computer Science")));

        applicantAnswers.add(new ApplicantAnswer(
                new char[]{'B', 'D', 'A', 'B', 'C', 'B', 'A', 'C', 'A',
                    'C', 'A', 'C', 'A', 'D', 'A', 'C', 'C', 'B', 'D', 'A'},
                new ApplicantDetails("Ali Ahmad",
                        "vyq112",
                        20,
                        "Male",
                        "Malaysian",
                        "Class 1",
                        "123",
                        "Computer Science")));

        // ApplicantName
        applicants = FileReadWrite.readAppTxt();

        cmbname = new ComboBox<Applicant>(FXCollections.observableArrayList(applicants));
        Label labName = new Label("Applicant Name: ");
        labName.setLayoutX(25); // without offset
        labName.setLayoutY(50); // without offset
        
        cmbname.setLayoutX(150);
        cmbname.setLayoutY(50);
        cmbname.setMinWidth(150);
        cmbname.setMaxWidth(150);

        // Max
        labMax.setLayoutX(25); // without offset
        labMax.setLayoutY(100); // without offset

        // Min
        labMin.setLayoutX(25); // without offset
        labMin.setLayoutY(150); // without offset

        //Average
        labAvg.setLayoutX(25); // without offset
        labAvg.setLayoutY(200); // without offset


        // Mode
        Label labMode = new Label("Mode: ");
        labMode.setLayoutX(25); // without offset
        labMode.setLayoutY(250); // without offset

        TextField txtMode = new TextField();
        txtMode.setLayoutX(150);
        txtMode.setLayoutY(250);

        // Back
        Button btnBack = new Button();
        btnBack.setLayoutX(50);
        btnBack.setLayoutY(300);
        btnBack.setText("Result Form");
        btnBack.setOnAction(e -> {
            toResultForm.navigate();
        });

        // MyQuiz
        Button btnExit = new Button();
        btnExit.setLayoutX(150);
        btnExit.setLayoutY(300);
        btnExit.setText("Back to Login Page");
        btnExit.setOnAction(e -> {
            toMyQuiz.navigate();
        });

        Pane p1 = new Pane();
        p1.getChildren().add(labName);
        p1.getChildren().add(labMax);
        p1.getChildren().add(labMin);
        p1.getChildren().add(labMode);
        p1.getChildren().add(labAvg);
        p1.getChildren().add(btnBack);
        p1.getChildren().add(btnExit);
        p1.getChildren().add(cmbname);
        p1.getChildren().add(txtMode);

        Scene myScene = new Scene(p1, 600, 400);
        this.setTitle("Analysis Form");
        this.setScene(myScene);
    }

    public void setToMyQuiz(NavigateToForm toMyQuiz) {
        this.toMyQuiz = toMyQuiz;
    }

    public void setToResultForm(NavigateToForm toResultForm) {
        this.toResultForm = toResultForm;
    }

    public void reloadPage() {
        int max = getMax();
        labMax.setText("Max: " + max + "/20");

        int min = getMin();
        labMin.setText("Min: " + min + "/20");

        int avg = getAvg();
        labAvg.setText("Average: " + avg + "/20");

    }

    public int getMax() {
        int maxScore = 0;
        for (int i = 0; i < applicantAnswers.size(); i++) {
            // write some logic to calcualte their score
            int individualScore = 0;
            char ans[] = applicantAnswers.get(i).getAnswers();
            for (int j = 0; j < correctAnswers.length; j++) {
                if (ans[j] == correctAnswers[j]) {
                    individualScore++;
                }
            }

            if (individualScore > maxScore) {
                maxScore = individualScore;
            }
        }

        return maxScore;
    }

    public int getMin() {
        int minScore = 20;
        for (int i = 0; i < applicantAnswers.size(); i++) {
            // write some logic to calcualte their score
            int individualScore = 20;
            char ans[] = applicantAnswers.get(i).getAnswers();
            for (int j = 0; j < correctAnswers.length; j++) {
                if (ans[j] == correctAnswers[j]) {
                    individualScore--;
                }
            }

            if (individualScore < minScore) {
                minScore = individualScore;
            }
        }

        return minScore;
    }

    public int getAvg() {
        int avgScore = 0;
        int maxScore = 0;
        for (int i = 0; i < applicantAnswers.size(); i++) {
            // write some logic to calcualte their score
            int individualScore = 0;
            char ans[] = applicantAnswers.get(i).getAnswers();
            for (int j = 0; j < correctAnswers.length; j++) {
                if (ans[j] == correctAnswers[j]) {
                    individualScore++;
                }
            }

            if (individualScore > maxScore) {
                maxScore = individualScore;
                avgScore = maxScore / 2;
            }
        }

        return avgScore;
    }

    public void getMode() {
        
    }
}
