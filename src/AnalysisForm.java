import java.util.LinkedList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.Arrays;

public class AnalysisForm extends Stage {
    
    
    private char correctAnswers[] = {'B', 'D', 'A', 'B', 'C', 'B', 'A', 'C', 'A',
        'C', 'D', 'A', 'B', 'D', 'A', 'C', 'C', 'B', 'D', 'A'};
    private LinkedList<ApplicantAnswer> applicantAnswers = new LinkedList<ApplicantAnswer>();

    private NavigateToForm toMyQuiz;
    private NavigateToForm toResultForm;

    private Label labMax = new Label("Max: ");
    private Label labMin = new Label("Min: ");
    private Label labAvg = new Label("Average: ");
    private Label labMed = new Label("Median: ");

    public AnalysisForm() {
        applicantAnswers.add(new ApplicantAnswer(
                new char[]{'B', 'C', 'B', 'D', 'A', 'B', 'A', 'C', 'A',
                    'C', 'D', 'A', 'B', 'D', 'A', 'C', 'C', 'B', 'D', 'A'},
                new ApplicantDetails("John Wong",
                        "abc123",
                        20,
                        "Male",
                        "Malaysian",
                        "Class 1",
                        "123",
                        "Computer Science")));

        applicantAnswers.add(new ApplicantAnswer(
                new char[]{'B', 'D', 'A', 'B', 'C', 'B', 'A', 'C', 'A',
                    'C', 'D', 'A', 'B', 'D', 'A', 'B', 'C', 'B', 'D', 'A'},
                new ApplicantDetails("Sarah Lee",
                        "def234",
                        20,
                        "Female",
                        "Malaysian",
                        "Class 1",
                        "123",
                        "Computer Science")));

        applicantAnswers.add(new ApplicantAnswer(
                new char[]{'B', 'D', 'A', 'B', 'C', 'B', 'A', 'C', 'A',
                    'C', 'A', 'C', 'A', 'D', 'A', 'C', 'C', 'B', 'D', 'A'},
                new ApplicantDetails("Ali Ahmad",
                        "vyq112",
                        20,
                        "Male",
                        "Malaysian",
                        "Class 1",
                        "123",
                        "Computer Science")));


        // Max
        labMax.setLayoutX(25); // without offset
        labMax.setLayoutY(50); // without offset

        // Min
        labMin.setLayoutX(25); // without offset
        labMin.setLayoutY(100); // without offset

        //Average
        labAvg.setLayoutX(25); // without offset
        labAvg.setLayoutY(150); // without offset

        // Mode
//        Label labMode = new Label("Mode: ");
//        labMode.setLayoutX(25); // without offset
//        labMode.setLayoutY(200); // without offset
        
        //Median
        labMed.setLayoutX(25); // without offset
        labMed.setLayoutY(200); // without offset
        

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
        p1.getChildren().add(labMax);
        p1.getChildren().add(labMin);
        p1.getChildren().add(labMed);
//        p1.getChildren().add(labMode);
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
        int max = getMax();
        labMax.setText("Max: " + max + "/20");

        int min = getMin();
        labMin.setText("Min: " + min + "/20");

        double avg = getAvg();
        labAvg.setText("Average: " + avg + "/20");

        int med = getMedian();
        labMed.setText("Median: " + med + "/20");
        
    }

// j = calculated score
// i = students
    
    public int getMax() {
        int maxScore = 0;
        for (int i = 0; i < applicantAnswers.size(); i++) {
            // write some logic to calcualte their score
            int individualScore = 0;
            char ans[] = applicantAnswers.get(i).getAnswers();
            for (int j = 0; j < correctAnswers.length; j++) {
                if (ans[j] == correctAnswers[j]) {
                    individualScore++;
                }
            }

            if (individualScore > maxScore) {
                maxScore = individualScore;
            }
        }

        return maxScore;
    }

    public int getMin() {
        int minScore = 20;
        for (int i = 0; i < applicantAnswers.size(); i++) {
            // write some logic to calcualte their score
            int individualScore = 20;
            char ans[] = applicantAnswers.get(i).getAnswers();
            for (int j = 0; j < correctAnswers.length; j++) {
                if (ans[j] == correctAnswers[j]) {
                    individualScore--;
                }
            }

            if (individualScore < minScore) {
                minScore = individualScore;
            }
        }

        return minScore;
    }

    public double getAvg() {
        int cumulativeScore = 0;
        for (int i = 0; i < applicantAnswers.size(); i++) {
            // write some logic to calcualte their score
            int individualScore = 0;
            char ans[] = applicantAnswers.get(i).getAnswers();
            for (int j = 0; j < correctAnswers.length; j++) {
                if (ans[j] == correctAnswers[j]) {
                    individualScore ++;
                }
            }
            cumulativeScore += individualScore;
        }
        
        double avgScore = cumulativeScore/applicantAnswers.size();
        return avgScore;
    }

    public int getMedian(){
        int scoresFinal[] = new int[applicantAnswers.size()];
        for (int i = 0; i < applicantAnswers.size(); i++) {
            // write some logic to calcualte their score
            int individualScore = 0;
            char ans[] = applicantAnswers.get(i).getAnswers();
            for (int j = 0; j < correctAnswers.length; j++) {
                if (ans[j] == correctAnswers[j]) {
                    individualScore ++;
                }
            }
            scoresFinal[i] = individualScore;
        }
        Arrays.sort(scoresFinal);
        int middleIndex = applicantAnswers.size()/2;
        return scoresFinal[middleIndex];
    }
    
//    public void getMode() {
//        
//    }
    
    
}
