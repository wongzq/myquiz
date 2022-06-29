import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.LinkedList;
;

public class LoginForm extends Stage {
    private LinkedList<Applicant> applicants;
    private ComboBox<Applicant> cmbname;
    
    public LoginForm() {
        
        applicants = FileReadWrite.readAppTxt();

        cmbname = new ComboBox<Applicant>(FXCollections.observableArrayList(applicants));
        // Username
        Label labName = new Label("Username: ");
        labName.setLayoutX(25); // without offset
        labName.setLayoutY(50); // without offset
 
        cmbname.setLayoutX(150);
        cmbname.setLayoutY(50);
        cmbname.setMinWidth(150);
        cmbname.setMaxWidth(150);

        // Password
        Label labResult = new Label("Password: ");
        labResult.setLayoutX(25); // without offset
        labResult.setLayoutY(100); // without offset

        TextField txtResult = new TextField();
        txtResult.setLayoutX(150);
        txtResult.setLayoutY(100);
        
        // LOGIN
        Button btnNext = new Button();
        btnNext.setLayoutX(25);
        btnNext.setLayoutY(150);
        btnNext.setText("Login");
        btnNext.setOnAction(e -> {
        });
        
        // Back
        Button btnBack = new Button();
        btnBack.setLayoutX(25);
        btnBack.setLayoutY(200);
        btnBack.setText("Back to MyQuiz");
        btnBack.setOnAction(e -> {
        });
        
        Pane p1 = new Pane();
        p1.getChildren().add(labName);
        p1.getChildren().add(labResult);
        p1.getChildren().add(txtResult);
        p1.getChildren().add(btnNext);
        p1.getChildren().add(btnBack);
        p1.getChildren().add(cmbname);

        Scene myScene = new Scene(p1, 600, 400);
        this.setTitle("Login Form");
        this.setScene(myScene);
    }
}

