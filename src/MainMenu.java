import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private JPanel MainPanel;
    private JButton settingsButton;
    private JButton back;
    private JButton diffofvec;
    private JButton sumofvec;
    private JButton scalarProductButton;
    private JButton multiplyByScalar;
    private JButton lengthOFVButton;
    private JButton button1;
    private JPanel panel1;

    CardLayout cardLayout = new CardLayout();
    public MainMenu(){
        setContentPane(MainPanel);
        setTitle("Vectors3D");
        setSize(1280,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        sumofvec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SumOfVGUI();
            }
        });

        diffofvec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SubtractionOfVGUI();
            }
        });

        scalarProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ScalarProductOfVGUI();
            }
        });

        multiplyByScalar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new multiplyVBySGUI();
            }
        });

        lengthOFVButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new lengthOfVGUI();
            }
        });

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new settingsGUI();
            }
        });
    }

    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        menu.setVisible(true);
    }

}
