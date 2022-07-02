
import java.io.File;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ExamForm extends Stage {

    private LinkedList<Question> questions = FileReadWrite.readQuesTxt();
    private int currQuestion = 0, totQues = 20;
    private char[] appAns;
    private final int offsetX = 100, offsetY = 75;

    private Label lblQuestion, lblAns1, lblAns2, lblAns3, lblAns4;
    private Label labA, labB, labC, labD;
    private Label labQuesNo;
    private Label labName, labNationality;
    private ImageView imgQuestion, imgAns1, imgAns2, imgAns3, imgAns4;
    private Button btnNext, btnPrev;
    private Button btnSubmit;
    private RadioButton radChoice1, radChoice2, radChoice3, radChoice4;
    private ToggleGroup grpChoices;
    private NavigateToForm toExitBox;
    private Timer timer;
    private Label lblTimer;
    private MediaPlayer mdPlayer;
    private Pane p2;

    public ExamForm() {
        this.setTitle("Exam Form");
        appAns = new char[20];
        reloadQues();
    }

    public void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int countdown = 600;

            public void run() {
                if (countdown > 0) {
                    countdown--;

                    if (countdown <= 180) {
                        Platform.runLater(() -> lblTimer.setText("Time to read the question: " + countdown));
                    } else {
                        Platform.runLater(() -> lblTimer.setText(""));
                    }
                    if (countdown == 10) {
                        String musicFile = "./data/Countdown.mp3";
                        Media sound = new Media(new File(musicFile).toURI().toString());
                        MediaPlayer mdPlayer;
                        mdPlayer = new MediaPlayer(sound);
                        mdPlayer.play();
                    }
                    if (countdown == 0) {
                        Platform.runLater(() -> saveAns());
                    }
                    System.out.println(countdown);
                } else {
                    timer.cancel();
                }
            }
        }, 0, 1000);
    }
    
    

    public void reloadQues() {
        //display name
        labName = new Label();
        labNationality = new Label();
        if (SharedData.getApplicant() != null) {
            labName.setLayoutX(1200);
            labName.setLayoutY(50);
            labName.setText("Name: " + SharedData.getApplicant().getName());
            labName.setStyle("-fx-font-family:Arial;-fx-font-size: 16px");
            //display nationality
            labNationality.setLayoutX(1200);
            labNationality.setLayoutY(100);
            labNationality.setStyle("-fx-font-family:Arial;-fx-font-size: 16px");
            labNationality.setText("Nationality: " + SharedData.getApplicant().getNationality());
        }

        //question
        lblQuestion = new Label(questions.get(currQuestion).getQuestion());
        lblQuestion.setLayoutX(60);
        lblQuestion.setLayoutY(100);
        lblQuestion.setStyle("-fx-font-family:Arial;-fx-font-size: 16px");

        //question image
        imgQuestion = new ImageView();
        imgQuestion.setLayoutX(50);
        imgQuestion.setLayoutY(80 + offsetY);
        imgQuestion.setImage(questions.get(currQuestion).getQuesImage());
        imgQuestion.setFitHeight(200);
        imgQuestion.setFitWidth(225);

        //answer
        lblAns1 = new Label(questions.get(currQuestion).getChoices()[0].getAnswer());
        lblAns2 = new Label(questions.get(currQuestion).getChoices()[1].getAnswer());
        lblAns3 = new Label(questions.get(currQuestion).getChoices()[2].getAnswer());
        lblAns4 = new Label(questions.get(currQuestion).getChoices()[3].getAnswer());
        lblAns1.setLayoutX(100);
        lblAns1.setLayoutY(300 + offsetY);
        lblAns1.setMaxWidth(300);
        lblAns1.setWrapText(true);
        lblAns1.setStyle("-fx-font-family:Arial;-fx-font-size: 15px");
        lblAns2.setLayoutX(350 + offsetX);
        lblAns2.setLayoutY(300 + offsetY);
        lblAns2.setMaxWidth(300);
        lblAns2.setWrapText(true);
        lblAns2.setStyle("-fx-font-family:Arial;-fx-font-size: 15px");
        lblAns3.setLayoutX(600 + 2 * offsetX);
        lblAns3.setLayoutY(300 + offsetY);
        lblAns3.setMaxWidth(300);
        lblAns3.setWrapText(true);
        lblAns3.setStyle("-fx-font-family:Arial;-fx-font-size: 15px");
        lblAns4.setLayoutX(850 + 3 * offsetX);
        lblAns4.setLayoutY(300 + offsetY);
        lblAns4.setMaxWidth(300);
        lblAns4.setWrapText(true);
        lblAns4.setStyle("-fx-font-family:Arial;-fx-font-size: 15px");

        //answer image
        imgAns1 = new ImageView();
        imgAns1.setLayoutX(75);
        imgAns1.setLayoutY(325 + offsetY);
        imgAns1.setImage(questions.get(currQuestion).getChoices()[0].getAnsImage());
        imgAns1.setFitHeight(200);
        imgAns1.setFitWidth(225);

        imgAns2 = new ImageView();
        imgAns2.setLayoutX(325 + offsetX);
        imgAns2.setLayoutY(325 + offsetY);
        imgAns2.setImage(questions.get(currQuestion).getChoices()[1].getAnsImage());
        imgAns2.setFitHeight(200);
        imgAns2.setFitWidth(225);

        imgAns3 = new ImageView();
        imgAns3.setLayoutX(575 + 2 * offsetX);
        imgAns3.setLayoutY(325 + offsetY);
        imgAns3.setImage(questions.get(currQuestion).getChoices()[2].getAnsImage());
        imgAns3.setFitHeight(200);
        imgAns3.setFitWidth(225);

        imgAns4 = new ImageView();
        imgAns4.setLayoutX(825 + 3 * offsetX);
        imgAns4.setLayoutY(325 + offsetY);
        imgAns4.setImage(questions.get(currQuestion).getChoices()[3].getAnsImage());
        imgAns4.setFitHeight(200);
        imgAns4.setFitWidth(225);

        //label Question No
        labQuesNo = new Label("Question " + Integer.toString(currQuestion + 1) + "/" + totQues);
        labQuesNo.setStyle("-fx-font-family:Arial;-fx-font-size: 20px;-fx-font-weight:bold");
        labQuesNo.setLayoutX(60);
        labQuesNo.setLayoutY(50);

        //label A,B,C,D
        labA = new Label("A.");
        labA.setLayoutX(50);
        labA.setLayoutY(300 + offsetY);
        labA.setStyle("-fx-font-family:Arial;-fx-font-size: 15px");
        radChoice1 = new RadioButton("");
        radChoice1.setLayoutX(75);
        radChoice1.setLayoutY(300 + offsetY);
        radChoice1.setOnAction(e -> {
            appAns[currQuestion] = 'A';
        });
        radChoice1.setSelected(appAns[currQuestion] == 'A');
        System.out.println(appAns);

        labB = new Label("B.");
        labB.setLayoutX(300 + offsetX);
        labB.setLayoutY(300 + offsetY);
        labB.setStyle("-fx-font-family:Arial;-fx-font-size: 15px");
        radChoice2 = new RadioButton("");
        radChoice2.setLayoutX(325 + offsetX);
        radChoice2.setLayoutY(300 + offsetY);
        radChoice2.setOnAction(e -> {
            appAns[currQuestion] = 'B';
        });
        radChoice2.setSelected(appAns[currQuestion] == 'B');

        labC = new Label("C.");
        labC.setLayoutX(550 + 2 * offsetX);
        labC.setLayoutY(300 + offsetY);
        labC.setStyle("-fx-font-family:Arial;-fx-font-size: 15px");
        radChoice3 = new RadioButton("");
        radChoice3.setLayoutX(575 + 2 * offsetX);
        radChoice3.setLayoutY(300 + offsetY);
        radChoice3.setOnAction(e -> {
            appAns[currQuestion] = 'C';
        });
        radChoice3.setSelected(appAns[currQuestion] == 'C');

        labD = new Label("D.");
        labD.setLayoutX(800 + 3 * offsetX);
        labD.setLayoutY(300 + offsetY);
        labD.setStyle("-fx-font-family:Arial;-fx-font-size: 15px");
        radChoice4 = new RadioButton("");
        radChoice4.setLayoutX(825 + 3 * offsetX);
        radChoice4.setLayoutY(300 + offsetY);
        radChoice4.setOnAction(e -> {
            appAns[currQuestion] = 'D';
        });
        radChoice4.setSelected(appAns[currQuestion] == 'D');

        grpChoices = new ToggleGroup();

        radChoice1.setToggleGroup(grpChoices);
        radChoice2.setToggleGroup(grpChoices);
        radChoice3.setToggleGroup(grpChoices);
        radChoice4.setToggleGroup(grpChoices);

        // next, previous, submit button
        btnNext = new Button();
        btnNext.setLayoutX(755);
        btnNext.setLayoutY(640);
        btnNext.setText("Next");
        btnNext.setStyle("-fx-pref-width: 100px;-fx-font-family:Arial;-fx-font-size: 15px");
        btnNext.setOnAction(e -> {
            if (currQuestion < questions.size() - 1) {
                currQuestion = currQuestion + 1;
                reloadQues();
            }

        });

        btnPrev = new Button();
        btnPrev.setLayoutX(555);
        btnPrev.setLayoutY(640);
        btnPrev.setText("Previous");
        btnPrev.setStyle("-fx-pref-width: 100px;-fx-font-family:Arial;-fx-font-size: 15px");
        btnPrev.setOnAction(e -> {
            if (currQuestion > 0) {
                currQuestion = currQuestion - 1;
                reloadQues();
            }

        });

        btnSubmit = new Button();
        btnSubmit.setText("Submit");
        btnSubmit.setLayoutX(655);
        btnSubmit.setLayoutY(700);
        btnSubmit.setStyle("-fx-pref-width: 100px;-fx-font-family:Arial;-fx-font-size: 15px");
        btnSubmit.setOnAction(e -> {
            saveAns();
            timer.cancel();

        });

        //timer
        lblTimer = new Label();
        lblTimer.setLayoutX(600);
        lblTimer.setLayoutY(200);
        lblTimer.setStyle("-fx-font-family:Arial;-fx-font-size: 18px");

        p2 = new Pane();
        p2.getChildren().add(labName);
        p2.getChildren().add(labNationality);
        p2.getChildren().add(lblQuestion);
        p2.getChildren().add(btnSubmit);
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

        Scene myScene = new Scene(p2, 1440, 800);
        this.setTitle("Exam Form");
        this.setScene(myScene);
    }

    private void saveAns() {
        ApplicantDetails applicant = SharedData.getApplicant();
        ApplicantAnswer ans = new ApplicantAnswer(appAns, applicant);

        FileReadWrite.writeExamAnsTxt(ans);
        toExitBox.navigate();
    }

    public void setToExitBox(NavigateToForm toExitBox) {
        this.toExitBox = toExitBox;
    }
}
