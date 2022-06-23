import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class Analysis implements ActionListener {
    JFrame f;
    JPanel p;
    JButton btnExit, btnNext;
    JTextField txtName, txtMax, txtMin, txtMode;
    JLabel labResult;
 
    public Analysis() {
        f = new JFrame();
        p = new JPanel();
    }
 
    public void init() {
        f.setTitle("Analysis Form");
        f.setSize(500,500); // size is whatever size the other forms are
        p.setLayout(null);
        
        //ApplicantName
        JLabel labName = new JLabel("Applicant Name: ");
        labName.setBounds(25,50,150,25);
        p.add(labName);
        
        txtName = new JTextField();
        txtName.setBounds(150,50,150,25);
        p.add(txtName);
        
        //Max
        JLabel labMax = new JLabel("Max: ");
        labMax.setBounds(25,100,150,25);
        p.add(labMax);
        
        txtMax = new JTextField();
        txtMax.setBounds(150,100,150,25);
        p.add(txtMax);
        
        //Min
        JLabel labMin = new JLabel("Min: ");
        labMin.setBounds(25,150,150,25);
        p.add(labMin);
        
        txtMin = new JTextField();
        txtMin.setBounds(150,150,150,25);
        p.add(txtMin);
        
        //Mode
        JLabel labMode = new JLabel("Mode: ");
        labMode.setBounds(25,200,150,25);
        p.add(labMode);

        txtMode = new JTextField();
        txtMode.setBounds(150,200,150,25);
        p.add(txtMode);
        
        //Next
        btnNext = new JButton("Next");
        btnNext.setBounds(350,300,100,25);
        btnNext.addActionListener(this);
        p.add(btnNext);
        
        labResult = new JLabel();
        labResult.setBounds(25,225,150,25);
        p.add(labResult);
        
        //Exit
        btnExit = new JButton("Exit");
        btnExit.setBounds(350,325,100,25);
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
        Analysis anl = new Analysis();
        anl.init();
    }
}