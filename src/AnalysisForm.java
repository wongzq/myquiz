
import java.util.LinkedList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;

public class AnalysisForm extends Stage {

    private char correctAnswers[] = FileReadWrite.readCorrectAnswers();
    private LinkedList<ApplicantAnswer> applicantAnswers = new LinkedList<ApplicantAnswer>();

    private NavigateToForm toMyQuiz;
    private NavigateToForm toResultForm;

    private Label labAnalysisForm = new Label("Analysis Form ");
    private Label labMax = new Label("Max: ");
    private Label labMin = new Label("Min: ");
    private Label labAvg = new Label("Average: ");
    private Label labMed = new Label("Median: ");

    public AnalysisForm() {

        applicantAnswers = FileReadWrite.readExamAnsTxt();
        
        // AnalysisForm Title
        labAnalysisForm.setLayoutX(25);
        labAnalysisForm.setLayoutY(30);
        labAnalysisForm.setStyle("-fx-font-family:Verdana; -fx-font-weight:bold; -fx-font-size: 18px");
        
        // Max
        labMax.setLayoutX(25); // without offset
        labMax.setLayoutY(65); // without offset
        labMax.setStyle("-fx-font-size: 12px");

        // Min
        labMin.setLayoutX(25); // without offset
        labMin.setLayoutY(115); // without offset
        labMin.setStyle("-fx-font-size: 12px");

        //Average
        labAvg.setLayoutX(25); // without offset
        labAvg.setLayoutY(165); // without offset
        labAvg.setStyle("-fx-font-size: 12px");

        //Median
        labMed.setLayoutX(25); // without offset
        labMed.setLayoutY(215); // without offset
        labMed.setStyle("-fx-font-size: 12px");

        // Back
        Button btnBack = new Button();
        btnBack.setLayoutX(50);
        btnBack.setLayoutY(300);
        btnBack.setText("Result Form");
        btnBack.setOnAction(e -> {
            toResultForm.navigate();
        });

        // MyQuiz
        Button btnExit = new Button();
        btnExit.setLayoutX(150);
        btnExit.setLayoutY(300);
        btnExit.setText("Back to MyQuiz");
        btnExit.setOnAction(e -> {
            toMyQuiz.navigate();
        });

        Pane p1 = new Pane();
        p1.getChildren().add(labAnalysisForm);
        p1.getChildren().add(labMax);
        p1.getChildren().add(labMin);
        p1.getChildren().add(labMed);
        p1.getChildren().add(labAvg);
        p1.getChildren().add(btnBack);
        p1.getChildren().add(btnExit);

        Scene myScene = new Scene(p1, 600, 400);
        this.setTitle("Analysis Form");
        this.setScene(myScene);
    }

    public void setToMyQuiz(NavigateToForm toMyQuiz) {
        this.toMyQuiz = toMyQuiz;
    }

    public void setToResultForm(NavigateToForm toResultForm) {
        this.toResultForm = toResultForm;
    }

    public void reloadPage() {

        applicantAnswers = FileReadWrite.readExamAnsTxt();
        System.out.println(applicantAnswers);

        int max = getMax();
        labMax.setText("Max Score: " + max + "/20");

        int min = getMin();
        labMin.setText("Min Score: " + min + "/20");

        double avg = getAvg();
        labAvg.setText("Average Score: " + avg + "/20");

        int med = getMedian();
        labMed.setText("Median Score: " + med + "/20");

    }

// j = calculated score
// i = students
    public int getMax() {
        int maxScore = 0;
        for (int i = 0; i < applicantAnswers.size(); i++) {
            int individualScore = applicantAnswers.get(i).getScore();
            if (individualScore > maxScore) {
                maxScore = individualScore;
            }
        }

        return maxScore;
    }

    public int getMin() {
        int minScore = 20;
        for (int i = 0; i < applicantAnswers.size(); i++) {
            int individualScore = applicantAnswers.get(i).getScore();

            if (individualScore < minScore) {
                minScore = individualScore;
            }
        }

        return minScore;
    }

    public double getAvg() {
        int cumulativeScore = 0;
        for (int i = 0; i < applicantAnswers.size(); i++) {
            int individualScore = applicantAnswers.get(i).getScore();

            cumulativeScore += individualScore;
        }

        double avgScore = cumulativeScore / applicantAnswers.size();
        return avgScore;
    }

    public int getMedian() {
        int scoresFinal[] = new int[applicantAnswers.size()];
        for (int i = 0; i < applicantAnswers.size(); i++) {
            int individualScore = applicantAnswers.get(i).getScore();

            scoresFinal[i] = individualScore;
        }
        Arrays.sort(scoresFinal);
        int middleIndex = applicantAnswers.size() / 2;
        return scoresFinal[middleIndex];
    }

}
