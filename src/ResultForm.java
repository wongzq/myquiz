import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ResultForm extends Stage {

    private ApplicantAnswer[] answers;

    public ResultForm() {

        // ApplicantName
        Label labName = new Label("Applicant: ");
        labName.setLayoutX(25); // without offset
        labName.setLayoutY(50); // without offset

        TextField txtName = new TextField();
        txtName.setLayoutX(150);
        txtName.setLayoutY(50);

        // Result
        Label labResult = new Label("Result: ");
        labResult.setLayoutX(25); // without offset
        labResult.setLayoutY(100); // without offset

        // Back
        Button btnBack = new Button();
        btnBack.setLayoutX(250);
        btnBack.setLayoutY(300);
        btnBack.setText("Analysis Form");
        btnBack.setOnAction(e -> {
            AnalysisForm analysisform = new AnalysisForm();
            analysisform.show();
            this.hide();

            analysisform.setOnHiding(e2 -> {
                this.show();
                analysisform.hide();
            });
        });

        // Exit
        Button btnExit = new Button();
        btnExit.setLayoutX(350);
        btnExit.setLayoutY(300);
        btnExit.setText("Exit");

        //LoginForm loginForm = new LoginForm();
        //btnExit.setOnAction(e -> {
        //loginForm.show();
        //this.hide();

        //loginForm.setOnHiding(e2 -> {
        //this.show();
        //loginForm.hide();
        //});
        //});
        Pane p1 = new Pane();
        p1.getChildren().add(labName);
        p1.getChildren().add(txtName);
        p1.getChildren().add(labResult);
        p1.getChildren().add(btnBack);
        p1.getChildren().add(btnExit);

        Scene myScene = new Scene(p1, 600, 400);
        this.setTitle("Result Form");
        this.setScene(myScene);
        this.show();
    }

    private void selectStudent() {

    }

    private void calcScore() {

    }

    private void passFail() {

    }

}
