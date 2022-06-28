import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ApplicantForm extends Stage{

	private Label labResult;
    private TextField txtName, txtClass, txtIDNo, txtCourse, txtNationality;
    private Button btnExamForm, btnGoBack, btnGotoMainMenu;
    private Pane p1;
    private Scene ApplicantScene;
    
    private NavigateToForm toExamForm;
    private NavigateToForm toLoginForm;
    private NavigateToForm toMyQuiz;

   // public ApplicantForm() {

    //}

    public ApplicantForm() {
        this.setTitle("APPLICANT FORM");

        Label labName = new Label("Name: ");
        labName.setLayoutX(50);
        labName.setLayoutY(200);
        txtName = new TextField();
        txtName.setLayoutX(200);
        txtName.setLayoutY(200);

        Label labClass = new Label("Class:  ");
        labClass.setLayoutX(50);
        labClass.setLayoutY(320);
        txtClass = new TextField();
        txtClass.setLayoutX(200);
        txtClass.setLayoutY(320);

        Label labIDNo = new Label("ID Number: ");
        labIDNo.setLayoutX(50);
        labIDNo.setLayoutY(450);
        txtIDNo = new TextField();
        txtIDNo.setLayoutX(200);
        txtIDNo.setLayoutY(450);

        Label labCourse = new Label("Course: ");
        labCourse.setLayoutX(50);
        labCourse.setLayoutY(575);
        txtCourse = new TextField();
        txtCourse.setLayoutX(200);
        txtCourse.setLayoutY(575);

        Label labNationality = new Label("Nationality: ");
        labNationality.setLayoutX(50);
        labNationality.setLayoutY(710);
        txtNationality = new TextField();
        txtNationality.setLayoutX(200);
        txtNationality.setLayoutY(710);

        btnExamForm = new Button("EXAM FORM");
        btnExamForm.setLayoutX(700);
        btnExamForm.setLayoutY(800);
        btnExamForm.setOnAction( e -> {
        	toExamForm.navigate();
        }); 
        
        btnGoBack = new Button();
        btnGoBack.setText("Go Back");
        btnGoBack.setLayoutX(580);
        btnGoBack.setLayoutY(800);
        btnGoBack.setOnAction( e ->{
        	toLoginForm.navigate();
        });
        
        btnGotoMainMenu = new Button();
        btnGotoMainMenu.setText("Go Back To Main Menu");
        btnGotoMainMenu.setLayoutX(380);
        btnGotoMainMenu.setLayoutY(800);
        btnGotoMainMenu.setOnAction( e ->{
        	toMyQuiz.navigate();
        });

        Label labResultLabel = new Label("A P P L I C A N T  F O R M ");
        labResultLabel.setLayoutX(50);
        labResultLabel.setLayoutY(100);
        labResult = new Label();
        labResult.setLayoutX(150);
        labResult.setLayoutY(100);

        p1 = new Pane();
        p1.getChildren().add(labName);
        p1.getChildren().add(txtName);
        p1.getChildren().add(labClass);
        p1.getChildren().add(txtClass);
        p1.getChildren().add(labIDNo);
        p1.getChildren().add(txtIDNo);
        p1.getChildren().add(labCourse);
        p1.getChildren().add(txtCourse);
        p1.getChildren().add(labNationality);
        p1.getChildren().add(txtNationality);
        p1.getChildren().add(labResultLabel);
        p1.getChildren().add(labResult);
        p1.getChildren().add(btnExamForm);
        p1.getChildren().add(btnGoBack);
        p1.getChildren().add(btnGotoMainMenu);
        ApplicantScene = new Scene(p1, 900, 1050);
        this.setScene(ApplicantScene);
    }

    public void setToExamForm(NavigateToForm toExamForm) {
    	this.toExamForm = toExamForm;
    }
    
    public void setToLoginForm(NavigateToForm toLoginForm) {
    	this.toLoginForm = toLoginForm;
    }
    
    public void setToMyQuiz(NavigateToForm toMyQuiz) {
    	this.toMyQuiz = toMyQuiz;
    }
    //private void saveDetails() {

   // }

}