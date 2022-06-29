import java.io.File;
import javafx.scene.image.Image;


public class Answer {

    private String answer;
    private String ansImage;

    public Answer(String answer, String ansImage) {
        this.answer = answer;
        this.ansImage = ansImage;
    }

    public String getAnswer() {
        return answer;
    }

    public Image getAnsImage() {
        File file = new File("data/pictures/" + this.ansImage);
        return new Image(file.toURI().toString());
    }
}
