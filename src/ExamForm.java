
import java.util.LinkedList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ExamForm extends Stage {

    private LinkedList<Question> questions = FileReadWrite.readQuesTxt();
    private int currQuestion = 0;
    private char[] appAns;

    private Label lblQuestion;
    private ImageView imgQuestion;
    private Button btnNext, btnPrev;
    private Button btnMainMenu;

    private NavigateToForm toMyQuiz;

    public ExamForm() {
        this.setTitle("Exam Form");
        reloadQues();
    }

    private void reloadQues() {
        //question
        lblQuestion = new Label(questions.get(currQuestion).getQuestion());
        lblQuestion.setLayoutX(50);
        lblQuestion.setLayoutY(50);
        
        //question image
        imgQuestion = new ImageView();
        imgQuestion.setLayoutX(50);
        imgQuestion.setLayoutY(70);
        imgQuestion.setImage(questions.get(currQuestion).getQuesImage());
        imgQuestion.setFitHeight(150);
        imgQuestion.setFitWidth(150);
        
        btnNext = new Button();
        btnNext.setLayoutX(500);
        btnNext.setLayoutY(800);
        btnNext.setText("Next");
        btnNext.setOnAction(e -> {
            if (currQuestion < questions.size() - 1) {
                currQuestion = currQuestion + 1;
                reloadQues();
            }

        });

        btnPrev = new Button();
        btnPrev.setLayoutX(400);
        btnPrev.setLayoutY(800);
        btnPrev.setText("Previous");
        btnPrev.setOnAction(e -> {
            if (currQuestion > 0) {
                currQuestion = currQuestion - 1;
                reloadQues();
            }

        });
        

        btnMainMenu = new Button();
        btnMainMenu.setText("Back to Main Menu");
        btnMainMenu.setLayoutX(600);
        btnMainMenu.setLayoutY(800);
        btnMainMenu.setOnAction(e -> {
            toMyQuiz.navigate();
        });

        Pane p2 = new Pane();
        p2.getChildren().add(lblQuestion);
        p2.getChildren().add(btnMainMenu);
        p2.getChildren().add(btnNext);
        p2.getChildren().add(btnPrev);
        p2.getChildren().add(imgQuestion);

        Scene myScene = new Scene(p2, 900, 1000);
        this.setTitle("Exam Form");
        this.setScene(myScene);
    }

    private void selectAns() {

    }

    public void setToMyQuiz(NavigateToForm toMyQuiz) {
        this.toMyQuiz = toMyQuiz;
    }
}
