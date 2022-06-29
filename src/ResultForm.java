
import java.util.LinkedList;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ResultForm extends Stage {

    private LinkedList<Applicant> applicants;
    private ComboBox<Applicant> cmbname;
    
    private ApplicantAnswer[] answers;

    private NavigateToForm toMyQuiz;
    private NavigateToForm toAnalysisForm;
    
    public ResultForm() {

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

        // Result
        Label labResult = new Label("Result: ");
        labResult.setLayoutX(25); // without offset
        labResult.setLayoutY(100); // without offset

        TextField txtResult = new TextField();
        txtResult.setLayoutX(150);
        txtResult.setLayoutY(100);

        //Pass
        Button btnPass = new Button();
        btnPass.setLayoutX(450);
        btnPass.setLayoutY(25);
        btnPass.setText("Pass");
        
        //Fail
        Button btnFail = new Button();
        btnFail.setLayoutX(500);
        btnFail.setLayoutY(25);
        btnFail.setText("Fail");

        //Answer
        Label labAnswer = new Label("Answers: ");
        labAnswer.setLayoutX(25); // without offset
        labAnswer.setLayoutY(200); // without offset

        //AllAnswer
        Label labAllAnswer = new Label("B, C, B, D, A, B, A, C, A, C, D, A, B, D, A, C, C, B, D, A");
        labAllAnswer.setLayoutX(100); // without offset
        labAllAnswer.setLayoutY(200); // without offset

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
        btnBack.setText("Back to Login Page");
        btnBack.setOnAction(e -> {
            toMyQuiz.navigate();
        });
        

        Pane p1 = new Pane();
        p1.getChildren().add(labName);
        p1.getChildren().add(cmbname);
        p1.getChildren().add(labResult);
        p1.getChildren().add(txtResult);
        p1.getChildren().add(btnPass);
        p1.getChildren().add(btnFail);
        p1.getChildren().add(labAnswer);
        p1.getChildren().add(labAllAnswer);
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
}


//private void selectStudent() {
//
//}
//
//private void calcScore() {
//
//}
//
//private void passFail() {
//
//}
