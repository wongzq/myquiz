
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MyQuiz extends Application {

    private Stage stage;
    private Label title, labResult, labResult2;
    private Button btnTeacher, btnStudent;
    private Pane p1;
    private Scene myScene;

    private LoginForm loginForm = new LoginForm();
    private ApplicantForm applicantForm = new ApplicantForm();
    private ExamForm examForm = new ExamForm();
    private ResultForm resultForm = new ResultForm();
    private AnalysisForm analysisForm = new AnalysisForm();
    private ExitBox exitBox = new ExitBox();
    private Label labTitle = new Label();

    public MyQuiz() {

        NavigateToForm toMyQuiz = new NavigateToForm() {
            @Override
            public void navigate() {
                stage.show();
                resultForm.hide();
                analysisForm.hide();
                loginForm.hide();
                applicantForm.hide();
                examForm.hide();
                exitBox.hide();
            }
        };
        loginForm.setToMyQuiz(toMyQuiz);
        resultForm.setToMyQuiz(toMyQuiz);
        analysisForm.setToMyQuiz(toMyQuiz);
        applicantForm.setToMyQuiz(toMyQuiz);
        exitBox.setToMyQuiz(toMyQuiz);

        //leave this for reference (only works when interface has one method)
//        resultForm.setToMyQuiz(() -> {
//            stage.show();
//            resultForm.hide();
//        });
        NavigateToForm toLoginForm = new NavigateToForm() {
            @Override
            public void navigate() {
                applicantForm.hide();
                loginForm.show();
            }
        };
        applicantForm.setToLoginForm(toLoginForm);

        NavigateToForm toApplicantForm = new NavigateToForm() {
            @Override
            public void navigate() {
                loginForm.hide();
                applicantForm.show();
            }
        };
        loginForm.setToApplicantForm(toApplicantForm);

        NavigateToForm toAnalysisForm = new NavigateToForm() {
            @Override
            public void navigate() {
                resultForm.hide();
                analysisForm.show();
                analysisForm.reloadPage();
            }

        };
        resultForm.setToAnalysisForm(toAnalysisForm);

        NavigateToForm toResultForm = new NavigateToForm() {
            @Override
            public void navigate() {
                analysisForm.hide();
                resultForm.show();
                resultForm.reloadPage();
            }
        };
        analysisForm.setToResultForm(toResultForm);

        NavigateToForm toExamForm = new NavigateToForm() {
            @Override
            public void navigate() {
                applicantForm.hide();
                examForm.show();
                examForm.startTimer();
                examForm.reloadQues();
            }
        };
        applicantForm.setToExamForm(toExamForm);

        NavigateToForm toExitBox = new NavigateToForm() {
            @Override
            public void navigate() {
                examForm.hide();
                exitBox.show();
            }
        };
        examForm.setToExitBox(toExitBox);
    }

    @Override
    public void start(Stage mainStage) {

        stage = mainStage;

        labResult = new Label();
        labResult.setLayoutX(250); // without offset
        labResult.setLayoutY(180); // without offset

        labResult2 = new Label();
        labResult2.setLayoutX(450); // without offset
        labResult2.setLayoutY(20); // without offset

        labTitle = new Label();
        labTitle.setLayoutX(500); // without offset
        labTitle.setLayoutY(200); // without offset
        labTitle.setText("Welcome to Agriculture Quiz !");
        labTitle.setStyle("-fx-pref-width: 600px;-fx-font-family:Arial;-fx-font-size: 30px");

        btnStudent = new Button();
        btnStudent.setLayoutX(640);
        btnStudent.setLayoutY(350);
        btnStudent.setStyle("-fx-pref-width: 150px;-fx-font-family:Arial;-fx-font-size: 15px;-fx-pref-height:30px");
        btnStudent.setText("I am a Student");
        btnStudent.setOnAction(e -> {
            loginForm.show();
            stage.hide();
        });

        btnTeacher = new Button();
        btnTeacher.setLayoutX(640);
        btnTeacher.setLayoutY(420);
        btnTeacher.setStyle("-fx-pref-width: 150px;-fx-font-family:Arial;-fx-font-size: 15px;-fx-pref-height:30px");
        btnTeacher.setText("I am a Teacher");
        btnTeacher.setOnAction(e -> {
            resultForm.show();
            stage.hide();
        });

        p1 = new Pane();
        p1.getChildren().add(labResult);
        p1.getChildren().add(labResult2);
        p1.getChildren().add(btnStudent);
        p1.getChildren().add(btnTeacher);
        p1.getChildren().add(labTitle);

        //Title
        myScene = new Scene(p1, 1440, 800);
        mainStage.setTitle("MyQuiz");
        mainStage.setScene(myScene);
        mainStage.show();

    }

    public static void main(String args[]) {
        Application.launch(args);
    }
}
