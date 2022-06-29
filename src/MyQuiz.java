import java.util.LinkedList;
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
                loginForm.hide();
                applicantForm.hide();
                examForm.hide();
            };
        };
        loginForm.setToMyQuiz(toMyQuiz);
        resultForm.setToMyQuiz(toMyQuiz);
        analysisForm.setToMyQuiz(toMyQuiz);
        applicantForm.setToMyQuiz(toMyQuiz);
        examForm.setToMyQuiz(toMyQuiz);
        
        //leave this for reference (only works when interface has one method)
//        resultForm.setToMyQuiz(() -> {
//            stage.show();
//            resultForm.hide();
//        });
        NavigateToForm toLoginForm = new NavigateToForm() {
        	public void navigate() {
        		applicantForm.hide();
        		loginForm.show();
        	}
        };
        applicantForm.setToLoginForm(toLoginForm);
        
        NavigateToForm toApplicantForm = new NavigateToForm() {
        	public void navigate() {
        		loginForm.hide();
        		applicantForm.show();
        	};
        };
        
        loginForm.setToApplicantForm(toApplicantForm);

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
        
        NavigateToForm toExamForm = new NavigateToForm() {
    		public void navigate() {
    			applicantForm.hide();
    			examForm.show();
    		}
    	};
    	applicantForm.setToExamForm(toExamForm);
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
        mainStage.setTitle("MyQuiz");
        mainStage.setScene(myScene);
        mainStage.show();
    }

    public static void main(String args[]) {
        Application.launch(args);
        LinkedList<Question> a = FileReadWrite.readQuesTxt();
        
        for (int b = 0 ; b < a.size() ; b++){
            System.out.println(b);
            System.out.println(a.get(b).getQuestion());
            System.out.println(a.get(b).getQuesImage());
            
            for(int z = 0; z < a.get(b).getChoices().length; z++){
                System.out.println(a.get(b).getChoices()[z].getAnswer());
                System.out.println(a.get(b).getChoices()[z].getAnsImage());
            }
        }
    }
}
