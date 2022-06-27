
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MyQuiz extends Application {

    public void start(Stage mainStage) {

        Label labResult = new Label();
        labResult.setLayoutX(250); // without offset
        labResult.setLayoutY(180); // without offset

        Label labResult2 = new Label();
        labResult2.setLayoutX(450); // without offset
        labResult2.setLayoutY(20); // without offset
        Button btnOK = new Button();
        btnOK.setLayoutX(250);
        btnOK.setLayoutY(160);
        btnOK.setText("Student");
        btnOK.setOnAction(e
                -> labResult.setText("Open Student Window")
        );

        Button btnOK2 = new Button();
        btnOK2.setLayoutX(250);
        btnOK2.setLayoutY(190);
        btnOK2.setText("Teacher");
        btnOK2.setOnAction(e
                -> labResult2.setText("Open Teacher Window")
        );

        Pane p1 = new Pane();
        p1.getChildren().add(labResult);
        p1.getChildren().add(labResult2);
        p1.getChildren().add(btnOK);
        p1.getChildren().add(btnOK2);

        Scene myScene = new Scene(p1, 600, 400);
        mainStage.setTitle("Login Page");
        mainStage.setScene(myScene);
        mainStage.show();
    }

    public static void main(String args[]) {
        Application.launch(args);

    }
}
