
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ResultForm extends Stage {

    private char correctAnswers[] = FileReadWrite.readCorrectAnswers();

    private LinkedList<Character> correctAns = new LinkedList<>();
    private LinkedList<ApplicantAnswer> applicantAnswers = new LinkedList<ApplicantAnswer>();
    private ComboBox<ApplicantAnswer> cmbName;

    private ApplicantAnswer[] answers;

    private NavigateToForm toMyQuiz;
    private NavigateToForm toAnalysisForm;

    private Label labResult = new Label("Result: ");
    private Label labScore = new Label("Score: ");
    private Button btnPass = new Button();
    private TableView table = new TableView();

    public ResultForm() {
        // ApplicantName
        applicantAnswers = FileReadWrite.readExamAnsTxt();
        Collections.sort(applicantAnswers);
        cmbName = new ComboBox<ApplicantAnswer>(FXCollections.observableArrayList(applicantAnswers));

        Label labName = new Label("Applicant: ");
        labName.setLayoutX(25); // without offset
        labName.setLayoutY(50); // without offset

        cmbName.setLayoutX(150);
        cmbName.setLayoutY(50);
        cmbName.setMinWidth(150);
        cmbName.setMaxWidth(150);
        cmbName.setOnAction(e -> {
            reloadApplicant();
        });

        // Result
        labResult.setLayoutX(25); // without offset
        labResult.setLayoutY(150); // without offset

        //Score
        labScore.setLayoutX(25);
        labScore.setLayoutY(100);

        //Pass or Fail
        btnPass.setLayoutX(450);
        btnPass.setLayoutY(25);

        //Next
        Button btnNext = new Button();
        btnNext.setLayoutX(50);
        btnNext.setLayoutY(700);
        btnNext.setText("Analysis Form");
        btnNext.setOnAction(e -> {
            toAnalysisForm.navigate();
        });

        //Back
        Button btnBack = new Button();
        btnBack.setLayoutX(150);
        btnBack.setLayoutY(700);
        btnBack.setText("Back to MyQuiz");
        btnBack.setOnAction(e -> {
            toMyQuiz.navigate();
        });

        //table view
        table = new TableView();
        TableColumn colQuesNo = new TableColumn("No.");
        TableColumn colAppAns = new TableColumn("Answers");
        TableColumn colCorrAns = new TableColumn("Correct Answer");
        TableColumn colStatus = new TableColumn("Status");

        colQuesNo.setCellValueFactory(new PropertyValueFactory("quesNo"));
        colAppAns.setCellValueFactory(new PropertyValueFactory("appAns"));
        colCorrAns.setCellValueFactory(new PropertyValueFactory("correctAns"));
        colStatus.setCellValueFactory(new PropertyValueFactory("status"));

        colQuesNo.prefWidthProperty().bind(table.widthProperty().multiply(0.1));
        colAppAns.prefWidthProperty().bind(table.widthProperty().multiply(0.3));
        colCorrAns.prefWidthProperty().bind(table.widthProperty().multiply(0.3));
        colStatus.prefWidthProperty().bind(table.widthProperty().multiply(0.3));

        table.getColumns().add(colQuesNo);
        table.getColumns().add(colAppAns);
        table.getColumns().add(colCorrAns);
        table.getColumns().add(colStatus);

        table.setLayoutX(25);
        table.setLayoutY(200);
        table.setStyle("-fx-font-size: 12pt;-fx-font-family:Verdana;");
        table.setPrefSize(550, 475);

        Pane p1 = new Pane();
        p1.getChildren().add(labName);
        p1.getChildren().add(cmbName);
        p1.getChildren().add(labResult);
        p1.getChildren().add(labScore);
        p1.getChildren().add(btnPass);
        p1.getChildren().add(btnNext);
        p1.getChildren().add(btnBack);
        p1.getChildren().add(table);

        Scene myScene = new Scene(p1, 600, 800);
        this.setTitle("Result Form");
        this.setScene(myScene);
    }

    public void setToMyQuiz(NavigateToForm toMyQuiz) {
        this.toMyQuiz = toMyQuiz;
    }

    public void setToAnalysisForm(NavigateToForm toAnalysisForm) {
        this.toAnalysisForm = toAnalysisForm;
    }

    public void reloadPage() {
        applicantAnswers = FileReadWrite.readExamAnsTxt();
        Collections.sort(applicantAnswers);
        cmbName = new ComboBox<ApplicantAnswer>(FXCollections.observableArrayList(applicantAnswers));
    }

    private void reloadApplicant() {
        int i = getSelectedIndex();

        if (i == -1) {
            btnPass.setText("-");
            btnPass.setStyle("-fx-background-color: -fx-base");
            labResult.setText("Result :");
            labScore.setText("Score :");
            table.getItems().clear();
            table.refresh();
        } else {
            int score = this.applicantAnswers.get(i).getScore();
            double scorePercentage = Math.round(((score / 20f) * 100f) * 100) / 100;
            labResult.setText("Result: " + scorePercentage + "%");
            labScore.setText("Score:" + score + "/20");
            if (scorePercentage < 70) {
                btnPass.setText("Fail");
                btnPass.setStyle("-fx-background-color: #ff0000; ");

            } else {
                btnPass.setText("Pass");
                btnPass.setStyle("-fx-background-color: #00ff00");
            }

            char[] appAnswers = applicantAnswers.get(i).getAnswers();
            for (int j = 0; j < appAnswers.length; j++) {
                int quesNo = j + 1;
                char appAns = appAnswers[j];
                char corrAns = correctAnswers[j];
                String status = appAns == corrAns ? "Correct" : "Wrong";
                table.getItems().add(new Result(quesNo, appAns, corrAns, status));
            }
            table.refresh();
        }
    }

    private int getSelectedIndex() {
        for (int i = 0; i < applicantAnswers.size(); i++) {
            ApplicantAnswer selectedApplicant = cmbName.getValue();
            if (selectedApplicant == null) {
                return -1;
            }

            String selectedName = selectedApplicant.getApplicant().getName();
            String applicantName = applicantAnswers.get(i).getApplicant().getName();
            if (selectedName.equals(applicantName)) {
                return i;

            }
        }
        return -1;
    }

}
