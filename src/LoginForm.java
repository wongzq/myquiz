
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.LinkedList;
import javafx.scene.control.PasswordField;

public class LoginForm extends Stage {

    private LinkedList<Applicant> applicants;
    private ComboBox<Applicant> cmbName;

    private Button btnLogin, btnMenu;
    private TextField txtPassword;
    private Label labName, labPassword;

    private NavigateToForm toMyQuiz;
    private NavigateToForm toApplicantForm;

    public LoginForm() {

        applicants = FileReadWrite.readAppTxt();

        cmbName = new ComboBox<Applicant>(FXCollections.observableArrayList(applicants));
        // Username
        labName = new Label("Username");
        labName.setStyle("-fx-pref-width: 125px;-fx-font-family:Arial;-fx-font-size: 15px");
        System.out.println();
        labName.setLayoutX(540); // without offset
        labName.setLayoutY(304); // without offset
        System.out.println(javafx.scene.text.Font.getFamilies());
        cmbName.setPromptText("Select your username");
        cmbName.setStyle("-fx-font-family:Arial;-fx-font-size: 15px");
        cmbName.setLayoutX(635);
        cmbName.setLayoutY(300);
        cmbName.setMinWidth(150);
        cmbName.setMaxWidth(250);

        // Password
        labPassword = new Label("Password");
        labPassword.setStyle("-fx-pref-width: 100px;-fx-font-family:Arial;-fx-font-size: 15px");
        labPassword.setLayoutX(540); // without offset
        labPassword.setLayoutY(379); // without offset

        txtPassword = new PasswordField();
        txtPassword.setPromptText("Enter your password");
        txtPassword.setStyle("-fx-font-family:Arial;-fx-font-size:15px");
        txtPassword.setLayoutX(635);
        txtPassword.setLayoutY(375);
        txtPassword.setMinWidth(200);

        // LOGIN
        btnLogin = new Button();
        btnLogin.setLayoutX(666);
        btnLogin.setLayoutY(475);
        btnLogin.setText("Login");
        btnLogin.setStyle("-fx-pref-width: 100px;-fx-font-family:Arial;-fx-font-size: 14px");
        btnLogin.setOnAction(e -> {
            if (login() == true) {
                toApplicantForm.navigate();
            }
        });

        // Back
        btnMenu = new Button();
        btnMenu.setLayoutX(55);
        btnMenu.setLayoutY(740);
        btnMenu.setText("Main Menu");
        btnMenu.setStyle("-fx-pref-width: 100px;-fx-font-family:Arial;-fx-font-size: 14px");
        btnMenu.setOnAction(e -> {
            toMyQuiz.navigate();
        });

        Pane p1 = new Pane();
        p1.getChildren().add(labName);
        p1.getChildren().add(labPassword);
        p1.getChildren().add(txtPassword);
        p1.getChildren().add(btnLogin);
        p1.getChildren().add(btnMenu);
        p1.getChildren().add(cmbName);

        Scene myScene = new Scene(p1, 1440, 800);
        this.setTitle("Login Form");
        this.setScene(myScene);

    }

    private boolean login() {
        if (cmbName.getValue() == null) {
            return false;
        }

        String name = cmbName.getValue().getName();
        String password = txtPassword.getText();

        System.out.println(name);
        System.out.println(password);

        for (int i = 0; i < this.applicants.size(); i++) {
            Applicant applicant = this.applicants.get(i);

            if (applicant.getName().equals(name) && applicant.isCorrectPassword(password)) {
                System.out.println(name);
                ApplicantDetails appDetails = new ApplicantDetails(applicant.getName(), "", 0, "", "", "", "", "");
                SharedData.setApplicant(appDetails);
                return true;
            }
        }
        return false;
    }

    public void setToMyQuiz(NavigateToForm toMyQuiz) {
        this.toMyQuiz = toMyQuiz;
    }

    public void setToApplicantForm(NavigateToForm toApplicantForm) {
        this.toApplicantForm = toApplicantForm;
    }

}
