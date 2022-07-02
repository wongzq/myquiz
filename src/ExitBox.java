
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ExitBox extends Stage {

    private Label labText;
    private Button btnExit;
    private NavigateToForm toMyQuiz;

    public ExitBox() {
        this.setTitle("End of Exam");
        labText = new Label("Thanks for taking part in the quiz !");
        labText.setLayoutX(100);
        labText.setLayoutY(50);
        btnExit = new Button("END");
        btnExit.setLayoutX(175);
        btnExit.setLayoutY(75);
        btnExit.setOnAction(e -> {
            toMyQuiz.navigate();
        });

        Pane pane = new Pane();
        pane.getChildren().add(labText);
        pane.getChildren().add(btnExit);
        
        this.setScene(new Scene(pane, 400, 150));
    }

    public void setToMyQuiz(NavigateToForm toMyQuiz) {
        this.toMyQuiz = toMyQuiz;
    }
    
    
    
    
}
