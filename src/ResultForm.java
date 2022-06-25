import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ResultForm extends Stage {
    private ApplicantAnswer[] answers;


    public ResultForm() {

    }

    public void start(Stage mainStage) {

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

        // Next
        Button btnBack = new Button();
        btnBack.setLayoutX(250);
        btnBack.setLayoutY(300);
        btnBack.setText("Analysis Form");
        //btnNext.setOnAction(e -> 
                
        //);

        // Exit
        Button btnExit = new Button();
        btnExit.setLayoutX(350);
        btnExit.setLayoutY(300);
        btnExit.setText("Exit");
        //btnNext.setOnAction(e -> 
                
        //);

        
        Pane p1 = new Pane();
        p1.getChildren().add(labName);
        p1.getChildren().add(txtName);
        p1.getChildren().add(labResult);
        p1.getChildren().add(btnBack);
        p1.getChildren().add(btnExit);

        Scene myScene = new Scene(p1, 600, 400);
        mainStage.setTitle("Result Form");
        mainStage.setScene(myScene);
        mainStage.show();  
    }


    public static void main(String args[]) {

    }

    private void selectStudent() {

    }

    private void calcScore() {

    }

    private void passFail() {

    }

}