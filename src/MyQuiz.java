import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MyQuiz extends Application {

    private Stage stage;
    private Label title;
    private Button btnTeacher;
    private Button btnStudent;

    private LoginForm loginForm = new LoginForm();
    private ApplicantForm applicantForm = new ApplicantForm();
    private ExamForm examForm = new ExamForm();
    private ResultForm resultForm = new ResultForm();
    private AnalysisForm analysisForm = new AnalysisForm();

    public MyQuiz() {
        NavigateToForm toMyQuiz = new NavigateToForm() {
            public void navigate() {
                stage.show();
                resultForm.hide();
                analysisForm.hide();
//                applicantForm.hide();
//                examForm.hide();
            };
        };
        resultForm.setToMyQuiz(toMyQuiz);
        analysisForm.setToMyQuiz(toMyQuiz);
//        loginForm.setToMyQuiz(toMyQuiz);
//        applicantForm.setToMyQuiz(toMyQuiz);
//        examForm.setToMyQuiz(toMyQuiz);
        
        //leave this for reference (only works when interface has one method)
//        resultForm.setToMyQuiz(() -> {
//            stage.show();
//            resultForm.hide();
//        });

        NavigateToForm toAnalysisForm = new NavigateToForm() {
            public void navigate() {
                resultForm.hide();
                analysisForm.show();
            };
        };
        resultForm.setToAnalysisForm(toAnalysisForm);
        
        NavigateToForm toResultForm = new NavigateToForm() {
            public void navigate() {
                analysisForm.hide();
                resultForm.show();
            };
        };
        analysisForm.setToResultForm(toResultForm);
    }

    
    @Override
    public void start(Stage mainStage) {

        stage = mainStage;

        Label labResult = new Label();
        labResult.setLayoutX(250); // without offset
        labResult.setLayoutY(180); // without offset

        Label labResult2 = new Label();
        labResult2.setLayoutX(450); // without offset
        labResult2.setLayoutY(20); // without offset
        Button btnStudent = new Button();
        btnStudent.setLayoutX(250);
        btnStudent.setLayoutY(160);
        btnStudent.setText("I am a Student");
        btnStudent.setOnAction(e -> {
            loginForm.show();
            stage.hide();
        });

        Button btnTeacher = new Button();
        btnTeacher.setLayoutX(250);
        btnTeacher.setLayoutY(190);
        btnTeacher.setText("I am a Teacher");
        btnTeacher.setOnAction(e -> {
            resultForm.show();
            stage.hide();
        });

        Pane p1 = new Pane();
        p1.getChildren().add(labResult);
        p1.getChildren().add(labResult2);
        p1.getChildren().add(btnStudent);
        p1.getChildren().add(btnTeacher);

        //Title
        Scene myScene = new Scene(p1, 600, 400);
        mainStage.setTitle("Login Page");
        mainStage.setScene(myScene);
        mainStage.show();
    }

    public static void main(String args[]) {
        Application.launch(args);
    }
}
