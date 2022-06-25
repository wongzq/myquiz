import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AnalysisForm extends Stage {

    private ApplicantAnswer[] answers;

    public AnalysisForm() {

        // ApplicantName
        Label labName = new Label("Applicant Name: ");
        labName.setLayoutX(25); // without offset
        labName.setLayoutY(50); // without offset

        TextField txtName = new TextField();
        txtName.setLayoutX(150);
        txtName.setLayoutY(150);

        // Max
        Label labMax = new Label("Max: ");
        labMax.setLayoutX(25); // without offset
        labMax.setLayoutY(100); // without offset

        TextField txtMax = new TextField();
        txtMax.setLayoutX(150);
        txtMax.setLayoutY(150);

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
        txtMode.setLayoutY(150);

        // Next
        Button btnNext = new Button();
        btnNext.setLayoutX(350);
        btnNext.setLayoutY(300);
        btnNext.setText("Result Form");
        btnNext.setOnAction(e -> {
            ResultForm resultForm = new ResultForm();
            resultForm.show();
            this.hide();

            resultForm.setOnHiding(e2 -> {
                this.show();
                resultForm.hide();
            });
        });

        // Exit
        Button btnExit = new Button();
        btnExit.setLayoutX(250);
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
        //);
        Pane p1 = new Pane();
        p1.getChildren().add(labName);
        p1.getChildren().add(labMax);
        p1.getChildren().add(labMin);
        p1.getChildren().add(btnNext);
        p1.getChildren().add(btnExit);
        p1.getChildren().add(txtName);
        p1.getChildren().add(txtMax);
        p1.getChildren().add(txtMin);
        p1.getChildren().add(txtMode);

        Scene myScene = new Scene(p1, 600, 400);
        this.setTitle("Analysis Form");
        this.setScene(myScene);
        this.show();
    }

    public static void main(String args[]) {

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
