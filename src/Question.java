
import java.io.File;
import javafx.scene.image.Image;

public class Question {

    private String question;
    private String quesImage;
    private Answer[] choices;
    private char correctAns;
    private int type;

    public Question(String question,
            String quesImage,
            Answer[] choices,
            char correctAns,
            int type) {
        this.question = question;
        this.quesImage = quesImage;
        this.choices = choices;
        this.correctAns = correctAns;
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public Image getQuesImage() {
        File file = new File("data/pictures/" + this.quesImage);
        return new Image(file.toURI().toString());
    }

    public Answer[] getChoices() {
        return choices;
    }
    
    public int getType() {
        return type;
    }

    public boolean isCorrectAns(char choice) {
        return this.correctAns == choice;
    }
}
