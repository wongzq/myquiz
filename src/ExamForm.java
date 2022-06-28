import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ExamForm extends Stage{
    private ApplicantDetails applicant;
    private Question[] questions;
    private int currQuestion;
    private char[] appAns; 
    
    private Button btnMainMenu;
    
    private NavigateToForm toMyQuiz;
    

    
    public ExamForm() {
    	this.setTitle("Exam Form");
    	
    	btnMainMenu = new Button();
    	btnMainMenu.setText("Back to Main Menu");
    	btnMainMenu.setLayoutX(600);
    	btnMainMenu.setLayoutY(800);
    	btnMainMenu.setOnAction( e ->{
    		toMyQuiz.navigate();
    	});
    	
    	Pane p2 = new Pane();
    	p2.getChildren().add(btnMainMenu);

    	Scene myScene = new Scene(p2, 900, 1000);
        this.setTitle("Exam Form");
        this.setScene(myScene);
    }
    

    private void reloadQues(){
        
    }
    
    private void selectAns(){
    
    }
    
    public void setToMyQuiz(NavigateToForm toMyQuiz) {
    	this.toMyQuiz = toMyQuiz;
    }
}