
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ApplicantForm extends Stage {

    private Label labName, labAge, labClass, labGender, labIDNo, labCourse, labNationality, labResultLabel;
    private TextField txtName, txtAge, txtClass, txtGender, txtIDNo, txtCourse, txtNationality;
    private Button btnExamForm, btnBack, btnMenu;
    private Pane p1;
    private Scene ApplicantScene;
    private final int offsetX = 500, offsetY = 50;

    private NavigateToForm toExamForm;
    private NavigateToForm toLoginForm;
    private NavigateToForm toMyQuiz;

    // public ApplicantForm() {
    //}
    public ApplicantForm() {
        this.setTitle("APPLICANT FORM");

        labName = new Label("Name: ");
        labName.setLayoutX(50 + offsetX);
        labName.setLayoutY(154 + offsetY);
        labName.setStyle("-fx-pref-width: 100px;-fx-font-family:Arial;-fx-font-size: 14px");
        txtName = new TextField();
        txtName.setLayoutX(200 + offsetX);
        txtName.setLayoutY(150 + offsetY);
        txtName.setPromptText("Enter your name");
        txtName.setMinWidth(150);
        txtName.setStyle("-fx-pref-width: 100px;-fx-font-family:Arial;-fx-font-size: 14px");

        labAge = new Label("Age: ");
        labAge.setLayoutX(50 + offsetX);
        labAge.setLayoutY(204 + offsetY);
        labAge.setStyle("-fx-pref-width: 100px;-fx-font-family:Arial;-fx-font-size: 14px");
        txtAge = new TextField();
        txtAge.setLayoutX(200 + offsetX);
        txtAge.setLayoutY(200 + offsetY);
        txtAge.setPromptText("Enter your age");
        txtAge.setMinWidth(150);
        txtAge.setStyle("-fx-pref-width: 100px;-fx-font-family:Arial;-fx-font-size: 14px");

        labClass = new Label("Class: ");
        labClass.setLayoutX(50 + offsetX);
        labClass.setLayoutY(254 + offsetY);
        labClass.setStyle("-fx-pref-width: 100px;-fx-font-family:Arial;-fx-font-size: 14px");
        txtClass = new TextField();
        txtClass.setLayoutX(200 + offsetX);
        txtClass.setLayoutY(254 + offsetY);
        txtClass.setPromptText("Enter your class");
        txtClass.setMinWidth(150);
        txtClass.setStyle("-fx-pref-width: 100px;-fx-font-family:Arial;-fx-font-size: 14px");

        labGender = new Label("Gender: ");
        labGender.setLayoutX(50 + offsetX);
        labGender.setLayoutY(304 + offsetY);
        labGender.setStyle("-fx-pref-width: 100px;-fx-font-family:Arial;-fx-font-size: 14px");
        txtGender = new TextField();
        txtGender.setLayoutX(200 + offsetX);
        txtGender.setLayoutY(300 + offsetY);
        txtGender.setPromptText("Enter your gender");
        txtGender.setMinWidth(150);
        txtGender.setStyle("-fx-pref-width: 100px;-fx-font-family:Arial;-fx-font-size: 14px");

        labIDNo = new Label("ID Number: ");
        labIDNo.setLayoutX(50 + offsetX);
        labIDNo.setLayoutY(354 + offsetY);
        labIDNo.setStyle("-fx-pref-width: 100px;-fx-font-family:Arial;-fx-font-size: 14px");
        txtIDNo = new TextField();
        txtIDNo.setLayoutX(200 + offsetX);
        txtIDNo.setLayoutY(350 + offsetY);
        txtIDNo.setPromptText("Enter your ID No.");
        txtIDNo.setMinWidth(150);
        txtIDNo.setStyle("-fx-pref-width: 100px;-fx-font-family:Arial;-fx-font-size: 14px");

        labCourse = new Label("Course: ");
        labCourse.setLayoutX(50 + offsetX);
        labCourse.setLayoutY(404 + offsetY);
        labCourse.setStyle("-fx-pref-width: 100px;-fx-font-family:Arial;-fx-font-size: 14px");
        txtCourse = new TextField();
        txtCourse.setLayoutX(200 + offsetX);
        txtCourse.setLayoutY(400 + offsetY);
        txtCourse.setPromptText("Enter your course");
        txtCourse.setMinWidth(150);
        txtCourse.setStyle("-fx-pref-width: 100px;-fx-font-family:Arial;-fx-font-size: 14px");

        labNationality = new Label("Nationality: ");
        labNationality.setLayoutX(50 + offsetX);
        labNationality.setLayoutY(454 + offsetY);
        labNationality.setStyle("-fx-pref-width: 100px;-fx-font-family:Arial;-fx-font-size: 14px");
        txtNationality = new TextField();
        txtNationality.setLayoutX(200 + offsetX);
        txtNationality.setLayoutY(450 + offsetY);
        txtNationality.setPromptText("Enter your name");
        txtNationality.setMinWidth(150);
        txtNationality.setStyle("-fx-pref-width: 100px;-fx-font-family:Arial;-fx-font-size: 14px");

        btnExamForm = new Button("Start Test");
        btnExamForm.setLayoutX(666);
        btnExamForm.setLayoutY(600);
        btnExamForm.setStyle("-fx-pref-width: 100px;-fx-font-family:Arial;-fx-font-size: 14px");
        btnExamForm.setOnAction(e -> {
            if (saveDetails() == true) {
                toExamForm.navigate();
            }
        });

        btnBack = new Button();
        btnBack.setText("Back");
        btnBack.setStyle("-fx-pref-width: 100px;-fx-font-family:Arial;-fx-font-size: 14px");
        btnBack.setLayoutX(55);
        btnBack.setLayoutY(35);
        btnBack.setOnAction(e -> {
            toLoginForm.navigate();
        });

        btnMenu = new Button();
        btnMenu.setLayoutX(55);
        btnMenu.setLayoutY(740);
        btnMenu.setText("Main Menu");
        btnMenu.setStyle("-fx-pref-width: 100px;-fx-font-family:Arial;-fx-font-size: 14px");
        btnMenu.setOnAction(e -> {
            toMyQuiz.navigate();
        });

        labResultLabel = new Label("APPLICANT FORM ");
        labResultLabel.setStyle("-fx-font-family:Arial;-fx-font-size:24pt");
        labResultLabel.setLayoutX(50 + offsetX);
        labResultLabel.setLayoutY(50 + offsetY);

        p1 = new Pane();
        p1.getChildren().add(labName);
        p1.getChildren().add(txtName);
        p1.getChildren().add(labAge);
        p1.getChildren().add(txtAge);
        p1.getChildren().add(labClass);
        p1.getChildren().add(txtClass);
        p1.getChildren().add(labGender);
        p1.getChildren().add(txtGender);
        p1.getChildren().add(labIDNo);
        p1.getChildren().add(txtIDNo);
        p1.getChildren().add(labCourse);
        p1.getChildren().add(txtCourse);
        p1.getChildren().add(labNationality);
        p1.getChildren().add(txtNationality);
        p1.getChildren().add(labResultLabel);
        p1.getChildren().add(btnExamForm);
        p1.getChildren().add(btnBack);
        p1.getChildren().add(btnMenu);
        ApplicantScene = new Scene(p1, 1440, 800);
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

    private boolean saveDetails() {
        if (txtAge.getText().equals("") || txtGender.getText().equals("")
                || txtNationality.getText().equals("") || txtClass.getText().equals("")
                || txtIDNo.getText().equals("") || txtCourse.getText().equals("")) {
            return false;
        }
        ApplicantDetails a = new ApplicantDetails(SharedData.getApplicant().getName(),
                "",
                Integer.parseInt(txtAge.getText()),
                txtGender.getText(),
                txtNationality.getText(),
                txtClass.getText(),
                txtIDNo.getText(),
                txtCourse.getText());
        SharedData.setApplicant(a);
        return true;
    }
}
