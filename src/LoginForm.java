
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.LinkedList;

public class LoginForm extends Stage {

    private LinkedList<Applicant> applicants;
    private ComboBox<Applicant> cmbname;

    private Button btnLogin;
    private Button btnMyQuiz;

    private NavigateToForm toMyQuiz;
    private NavigateToForm toApplicantForm;

    public LoginForm() {

        btnMyQuiz = new Button();
        btnMyQuiz.setLayoutX(400);
        btnMyQuiz.setLayoutY(320);
        btnMyQuiz.setText("Go back");
        btnMyQuiz.setOnAction(e -> {
            toMyQuiz.navigate();
        });

        btnLogin = new Button();
        btnLogin.setText("Login");
        btnLogin.setLayoutX(500);
        btnLogin.setLayoutY(320);
        btnLogin.setOnAction(e -> {
            toApplicantForm.navigate();
        });

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
            toApplicantForm.navigate();
        });

        // Back
        Button btnBack = new Button();
        btnBack.setLayoutX(25);
        btnBack.setLayoutY(200);
        btnBack.setText("Back to MyQuiz");
        btnBack.setOnAction(e -> {
            toMyQuiz.navigate();
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

//    private boolean login(){
//        if (cmbName.getValue() == null)
//            return false;
//        
//        String name = cmbName.getValue().getName();
//        String passwrod = pwdPassword.getText();
//    
//        for (int i = 0; i < this.applicants.size(); i++){
//            Applicant applicant = this.applicants.get(i);
//                
//            if(applicant.getName() == name 66 applicant.isCorrectPassword(password)) {
//            Session.setApplicant(applicant);
//            return true;
//            }
//        }
//        return false;
//    }
//
    public void setToMyQuiz(NavigateToForm toMyQuiz) {
        this.toMyQuiz = toMyQuiz;
    }

    public void setToApplicantForm(NavigateToForm toApplicantForm) {
        this.toApplicantForm = toApplicantForm;
    }
}
