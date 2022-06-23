import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class FileReadWrite extends Application {
   
    private Label labResult;
    private TextField txtName, txtClass, txtID, txtCourse, txtNation;
    private Button btnSave, btnRead;
    private Pane p1;
    private Scene myScene;
    private File myf = new File("./data", "student.txt");
    
    public void start(Stage mainStage) {
        
        Label labTitle = new Label("Input Detail: ");
        labTitle.setLayoutX(50);
        labTitle.setLayoutY(30);
        
        //Code example for TextField
        Label labName = new Label("Name: ");
        labName.setLayoutX(50);
        labName.setLayoutY(60);
        txtName = new TextField();
        txtName.setLayoutX(200);
        txtName.setLayoutY(60);
        
        Label labClass = new Label("Class: ");
        labClass.setLayoutX(50);
        labClass.setLayoutY(90);
        txtClass = new TextField();
        txtClass.setLayoutX(200);
        txtClass.setLayoutY(90);

        Label labID = new Label("ID Number: ");
        labID.setLayoutX(50);
        labID.setLayoutY(120);
        txtID = new TextField();
        txtID.setLayoutX(200);
        txtID.setLayoutY(120);
        
        Label labCourse = new Label("Course: ");
        labCourse.setLayoutX(50);
        labCourse.setLayoutY(150);
        txtCourse = new TextField();
        txtCourse.setLayoutX(200);
        txtCourse.setLayoutY(150);
        
        Label labNation = new Label("Nationality: ");
        labNation.setLayoutX(50);
        labNation.setLayoutY(180);
        txtNation = new TextField();
        txtNation.setLayoutX(200);
        txtNation.setLayoutY(180);
        
        Label labResultLabel = new Label("R E S U L T :");
        labResultLabel.setLayoutX(50);
        labResultLabel.setLayoutY(260);
        labResult = new Label();
        labResult.setLayoutX(200);
        labResult.setLayoutY(260);
        
        btnSave = new Button("Save");
        btnSave.setLayoutX(50);
        btnSave.setLayoutY(310);
        //Code example for Add button event
        btnSave.setOnAction(e -> {
            saveToFile();
            labResult.setText("Saving data " + txtName.getText());
        });
        
        btnRead = new Button("Read");
        btnRead.setLayoutX(100);
        btnRead.setLayoutY(310);
        btnRead.setOnAction(e -> {
            readFromFile();
        });
        
        
        Pane p1 = new Pane();
        p1.getChildren().add(labTitle);
        p1.getChildren().add(labName);
        p1.getChildren().add(txtName);
        p1.getChildren().add(labClass);
        p1.getChildren().add(txtClass);
        p1.getChildren().add(labID);
        p1.getChildren().add(txtID);
        p1.getChildren().add(labCourse);
        p1.getChildren().add(txtCourse);
        p1.getChildren().add(labNation);
        p1.getChildren().add(txtNation);     
        p1.getChildren().add(btnSave);
        p1.getChildren().add(btnRead);
        p1.getChildren().add(labResult);
        p1.getChildren().add(labResultLabel);
        Scene myScene = new Scene(p1, 800, 500);
        mainStage.setTitle("Applicant Form");
        mainStage.setScene(myScene);
        mainStage.show();     
    }
   
    public void saveToFile() {
            try {
                PrintWriter pw = new PrintWriter(new FileWriter(myf, true));
                pw.println();
                pw.print(txtName.getText() + ", ");
                pw.print(txtClass.getText()+ ", ");
                pw.print(txtID.getText() + ", ");
                pw.print(txtCourse.getText()+ ", ");
                pw.print(txtNation.getText());
                pw.close();
            }
            catch(IOException e) {
            }
        }
    
    public void readFromFile() {
        Scanner sfile;
        String name, clss, course, nation;
        String id;
        Student stu;
        
        try{
            sfile = new Scanner(myf);
            while (sfile.hasNextLine()) {
                String aLine = sfile.nextLine();
                Scanner sline = new Scanner(aLine);
                sline.useDelimiter(",");
                while (sline.hasNext()) {
                    name = sline.next();
                    clss = sline.next();
                    id = sline.next();
                    course = sline.next();
                    nation = sline.next();
                    stu = new Student(name, clss, id, course, nation);
                    labResult.setText(labResult.getText() + "\n"
                        + "Name: " + stu.getName() + "    " 
                        + "Class: " + stu.getClss() + "    "
                        + "ID Number: " + stu.getID() + "    " 
                        + "Course: " + stu.getCourse() + "    "
                        + "Nationality: " + stu.getNation());
                }
                sline.close();
            }
            sfile.close();
        }
        catch(FileNotFoundException e) {
            labResult.setText("File to read " + myf + " not found!");
        }
    }

    
    public static void main(String args[]) {
        Application.launch(args);
    }   
}
