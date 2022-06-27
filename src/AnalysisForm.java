import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AnalysisForm extends Stage {

    private ApplicantAnswer[] answers;

    private NavigateToForm toMyQuiz;
    private NavigateToForm toResultForm;
    
    public AnalysisForm() {

        // ApplicantName
        Label labName = new Label("Applicant Name: ");
        labName.setLayoutX(25); // without offset
        labName.setLayoutY(50); // without offset

        TextField txtName = new TextField();
        txtName.setLayoutX(150);
        txtName.setLayoutY(50);

        // Max
        Label labMax = new Label("Max: ");
        labMax.setLayoutX(25); // without offset
        labMax.setLayoutY(100); // without offset
        TextField txtMax = new TextField();
        txtMax.setLayoutX(150);
        txtMax.setLayoutY(100);

        // Min
        Label labMin = new Label("Min: ");
        labMin.setLayoutX(25); // without offset
        labMin.setLayoutY(150); // without offset

        TextField txtMin = new TextField();
        txtMin.setLayoutX(150);
        txtMin.setLayoutY(150);

        // Mode
        Label labMode = new Label("Mode: ");
        labMode.setLayoutX(25); // without offset
        labMode.setLayoutY(200); // without offset

        TextField txtMode = new TextField();
        txtMode.setLayoutX(150);
        txtMode.setLayoutY(200);

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
        p1.getChildren().add(btnBack);
        p1.getChildren().add(btnExit);
        p1.getChildren().add(txtName);
        p1.getChildren().add(txtMax);
        p1.getChildren().add(txtMin);
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

    public void getMax() {

    }

    public void getMin() {

    }

    public void getAvg() {

    }

    public void getMode() {

    }
}
