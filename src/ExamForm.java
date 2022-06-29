
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ExamForm extends Stage {

    private LinkedList<Question> questions = FileReadWrite.readQuesTxt();
    private int currQuestion = 0;
    private char[] appAns;

    private Label lblQuestion, lblAns1, lblAns2, lblAns3, lblAns4;
    private Label labA, labB, labC, labD;
    private Label labQuesNo;
    private ImageView imgQuestion, imgAns1, imgAns2, imgAns3, imgAns4;
    private Button btnNext, btnPrev;
    private Button btnMainMenu;
    private RadioButton radChoice1, radChoice2, radChoice3, radChoice4;
    private ToggleGroup grpChoices;
    private NavigateToForm toMyQuiz;
    private Timer timer;
    private Label lblTimer;

    public ExamForm() {
        this.setTitle("Exam Form");
        appAns = new char[20];
        reloadQues();
    }

    public void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int countdown = 10;

            public void run() {
                if (countdown > 0) {
                    Platform.runLater(() -> lblTimer.setText("Time to read the question: "+countdown));
                    countdown--;
                    System.out.println(countdown);
                } else {
                    timer.cancel();
                }
            }

        }, 0, 1000);
    }

    private void reloadQues() {
        //question
        lblQuestion = new Label(questions.get(currQuestion).getQuestion());
        lblQuestion.setLayoutX(60);
        lblQuestion.setLayoutY(50);

        //question image
        imgQuestion = new ImageView();
        imgQuestion.setLayoutX(50);
        imgQuestion.setLayoutY(80);
        imgQuestion.setImage(questions.get(currQuestion).getQuesImage());
        imgQuestion.setFitHeight(200);
        imgQuestion.setFitWidth(225);

        //answer
        lblAns1 = new Label("A. " + questions.get(currQuestion).getChoices()[0].getAnswer());
        lblAns2 = new Label("B. " + questions.get(currQuestion).getChoices()[1].getAnswer());
        lblAns3 = new Label("C. " + questions.get(currQuestion).getChoices()[2].getAnswer());
        lblAns4 = new Label("D. " + questions.get(currQuestion).getChoices()[3].getAnswer());
        lblAns1.setLayoutX(75);
        lblAns1.setLayoutY(300);
        lblAns2.setLayoutX(325);
        lblAns2.setLayoutY(300);
        lblAns3.setLayoutX(75);
        lblAns3.setLayoutY(575);
        lblAns4.setLayoutX(325);
        lblAns4.setLayoutY(575);

        //answer image
        imgAns1 = new ImageView();
        imgAns1.setLayoutX(50);
        imgAns1.setLayoutY(325);
        imgAns1.setImage(questions.get(currQuestion).getChoices()[0].getAnsImage());
        imgAns1.setFitHeight(200);
        imgAns1.setFitWidth(225);

        imgAns2 = new ImageView();
        imgAns2.setLayoutX(300);
        imgAns2.setLayoutY(325);
        imgAns2.setImage(questions.get(currQuestion).getChoices()[1].getAnsImage());
        imgAns2.setFitHeight(200);
        imgAns2.setFitWidth(225);

        imgAns3 = new ImageView();
        imgAns3.setLayoutX(50);
        imgAns3.setLayoutY(600);
        imgAns3.setImage(questions.get(currQuestion).getChoices()[2].getAnsImage());
        imgAns3.setFitHeight(200);
        imgAns3.setFitWidth(225);

        imgAns4 = new ImageView();
        imgAns4.setLayoutX(300);
        imgAns4.setLayoutY(600);
        imgAns4.setImage(questions.get(currQuestion).getChoices()[3].getAnsImage());
        imgAns4.setFitHeight(200);
        imgAns4.setFitWidth(225);

        //label Question No
        labQuesNo = new Label(Integer.toString(currQuestion + 1));
        labQuesNo.setLayoutX(45);
        labQuesNo.setLayoutY(50);

        //label A,B,C,D
        labA = new Label();
        labA.setLayoutX(50);
        labA.setLayoutY(300);
        radChoice1 = new RadioButton("");
        radChoice1.setLayoutX(50);
        radChoice1.setLayoutY(300);
        radChoice1.setOnAction(e -> {
            appAns[currQuestion] = 'A';
        });
        radChoice1.setSelected(appAns[currQuestion] == 'A');
        System.out.println(appAns);

        labB = new Label();
        labB.setLayoutX(300);
        labB.setLayoutY(300);
        radChoice2 = new RadioButton("");
        radChoice2.setLayoutX(300);
        radChoice2.setLayoutY(300);
        radChoice2.setOnAction(e -> {
            appAns[currQuestion] = 'B';
        });
        radChoice2.setSelected(appAns[currQuestion] == 'B');

        labC = new Label();
        labC.setLayoutX(50);
        labC.setLayoutY(575);
        radChoice3 = new RadioButton("");
        radChoice3.setLayoutX(50);
        radChoice3.setLayoutY(575);
        radChoice3.setOnAction(e -> {
            appAns[currQuestion] = 'C';
        });
        radChoice3.setSelected(appAns[currQuestion] == 'C');

        labD = new Label();
        labD.setLayoutX(300);
        labD.setLayoutY(575);
        radChoice4 = new RadioButton("");
        radChoice4.setLayoutX(300);
        radChoice4.setLayoutY(575);
        radChoice4.setOnAction(e -> {
            appAns[currQuestion] = 'D';
        });
        radChoice4.setSelected(appAns[currQuestion] == 'D');

        grpChoices = new ToggleGroup();

        radChoice1.setToggleGroup(grpChoices);
        radChoice2.setToggleGroup(grpChoices);
        radChoice3.setToggleGroup(grpChoices);
        radChoice4.setToggleGroup(grpChoices);

        // next, previous, back to main menu button
        btnNext = new Button();
        btnNext.setLayoutX(600);
        btnNext.setLayoutY(900);
        btnNext.setText("Next");
        btnNext.setOnAction(e -> {
            if (currQuestion < questions.size() - 1) {
                currQuestion = currQuestion + 1;
                reloadQues();
            }

        });

        btnPrev = new Button();
        btnPrev.setLayoutX(500);
        btnPrev.setLayoutY(900);
        btnPrev.setText("Previous");
        btnPrev.setOnAction(e -> {
            if (currQuestion > 0) {
                currQuestion = currQuestion - 1;
                reloadQues();
            }

        });

        btnMainMenu = new Button();
        btnMainMenu.setText("Back to Main Menu");
        btnMainMenu.setLayoutX(750);
        btnMainMenu.setLayoutY(900);
        btnMainMenu.setOnAction(e -> {
            toMyQuiz.navigate();
        });
        
        //timer
        lblTimer = new Label();
        lblTimer.setLayoutX(700);
        lblTimer.setLayoutY(50);
        
        Pane p2 = new Pane();
        p2.getChildren().add(lblQuestion);
        p2.getChildren().add(btnMainMenu);
        p2.getChildren().add(btnNext);
        p2.getChildren().add(btnPrev);
        p2.getChildren().add(imgQuestion);
        p2.getChildren().add(lblAns1);
        p2.getChildren().add(lblAns2);
        p2.getChildren().add(lblAns3);
        p2.getChildren().add(lblAns4);
        p2.getChildren().add(imgAns1);
        p2.getChildren().add(imgAns2);
        p2.getChildren().add(imgAns3);
        p2.getChildren().add(imgAns4);
        p2.getChildren().add(labA);
        p2.getChildren().add(radChoice1);
        p2.getChildren().add(labB);
        p2.getChildren().add(radChoice2);
        p2.getChildren().add(labC);
        p2.getChildren().add(radChoice3);
        p2.getChildren().add(labD);
        p2.getChildren().add(radChoice4);
        p2.getChildren().add(labQuesNo);
        p2.getChildren().add(lblTimer);

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
