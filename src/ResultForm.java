import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ResultForm implements ActionListener {
    private ApplicantAnswer[] answers;

    JFrame f;
    JPanel p;
    JButton btnExit, btnNext;
    JTextField txtName;
    JLabel labResult;

    public ResultForm() {
        f = new JFrame();
        p = new JPanel();
    }

    public void init() {
        f.setTitle("Result Form");
        f.setSize(500, 500); // size is whatever size the other forms are
        p.setLayout(null);

        // ApplicantName
        JLabel labName = new JLabel("Applicant: ");
        labName.setBounds(25, 50, 150, 25);
        p.add(labName);

        txtName = new JTextField();
        txtName.setBounds(150, 50, 150, 25);
        p.add(txtName);

        // Result
        JLabel labResult = new JLabel("Result: ");
        labResult.setBounds(25, 100, 150, 25);
        p.add(labResult);

        // Next
        btnNext = new JButton("Analysis Form");
        btnNext.setBounds(25, 300, 125, 25);
        btnNext.addActionListener(this);
        p.add(btnNext);

        labResult = new JLabel();
        labResult.setBounds(25, 225, 150, 25);
        p.add(labResult);

        // Exit
        btnExit = new JButton("Exit"); // Go to main menu?
        btnExit.setBounds(150, 300, 100, 25);
        btnExit.addActionListener(this);
        p.add(btnExit);

        f.add(p);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnExit)
            System.exit(0);
        else if (e.getSource() == btnNext) {
            labResult.setText(txtName.getText());
        }
    }

    public static void main(String args[]) {
        ResultForm res = new ResultForm();
        res.init();
    }

    private void selectStudent() {

    }

    private void calcScore() {

    }

    private void passFail() {

    }

}