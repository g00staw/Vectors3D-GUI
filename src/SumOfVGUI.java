import javax.swing.*;

public class SumOfVGUI extends JFrame {
    private JPanel SumOfVGUI;
    private JPanel sumMainP;
    private JPanel panel1;
    private JButton ustawieniaButton;
    private JButton back;
    private JButton button1;
    private JTable table1;
    private JRadioButton bazaDomyślnaRadioButton;
    private JRadioButton bazaUżytkownikaRadioButton;
    private JButton zapiszButton;
    private JButton wyczyśćButton;
    private JButton obliczButton;

    public SumOfVGUI(){
        setContentPane(sumMainP);
        setTitle("Vectors3D - Sum of vectors");
        setSize(1280,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void launchSumOfVGUI(){
        SumOfVGUI sumOfVGUI = new SumOfVGUI();
        sumOfVGUI.setVisible(true);
    }
}
