
import java.io.File;
import javafx.scene.image.Image;

public class Question {

    private String question;
    private String quesImage;
    private Answer[] choices;
    private char correctAns;

    public Question(String question,
            String quesImage,
            Answer[] choices,
            char correctAns) {
        this.question = question;
        this.quesImage = quesImage;
        this.choices = choices;
        this.correctAns = correctAns;
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

    public boolean isCorrectAns(char choice) {
        return this.correctAns == choice;
    }
}
