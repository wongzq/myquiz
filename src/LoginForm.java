import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class LoginForm extends Stage {
    private Applicant[] validApplicants;

    private Label lblUsername;
    private ComboBox<Applicant> cmbUsername;

    private Label lblPassword;
    private TextField txtPassword;
    private Label lblError;

    private Button btnLogin;
    private Button btnMyQuiz;


    private NavigateToForm toMyQuiz;
    private NavigateToForm toApplicantForm;

    public LoginForm() {
        Applicant applicants[] = new Applicant[10];
//        applicants[0] = new Applicant(name:"Jacquliene", password:"aaa111");
//        applicants[1] = new Applicant(name:"Joshua", password:"bbb222");
//        applicants[2] = new Applicant(name:"Jeremy", password:"ccc333");
//        applicants[3] = new Applicant(name:"Jack", password:"ddd444");
//        applicants[4] = new Applicant(name:"John", password:"eee555");
//        applicants[5] = new Applicant(name:"Jane", password:"fff666");
//        applicants[6] = new Applicant(name:"Jeffrey", password:"ggg777");
//        applicants[7] = new Applicant(name:"Jennifer", password:"hhh888");
//        applicants[8] = new Applicant(name:"Jacob", password:"iii999");
//        applicants[9] = new Applicant(name:"James", password:"jjj000");

        this.setTitle ("Login Form");
        lblUsername = new Label();
        lblPassword = new Label();
//        cmbUsername = new ComboBox<Applicant>(FXCollections.observeableArrayList(applicants));
//        cmbUsername.setPromptText(value: "Select your name");
        txtPassword = new TextField();
        
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
        

        //username
        lblUsername.setLayoutX(180);
        lblUsername.setLayoutY(180);
        
        //password
        lblPassword.setLayoutX(180);
        lblPassword.setLayoutY(230);
        
        Pane p1 = new Pane();
        p1.getChildren().add(lblUsername);
        p1.getChildren().add(lblPassword);
        p1.getChildren().add(btnLogin);
        p1.getChildren().add(btnMyQuiz);
        
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
    public void setToMyQuiz (NavigateToForm toMyQuiz) {
    	this.toMyQuiz = toMyQuiz;
    }
    
    public void setToApplicantForm (NavigateToForm toApplicantForm) {
    	this.toApplicantForm = toApplicantForm;
    }
}
