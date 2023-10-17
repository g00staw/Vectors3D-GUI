import javax.swing.*;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {
    private JPanel MainPanel;
    private JButton ustawieniaButton;
    private JButton back;
    private JButton diffofvec;
    private JButton sumofvec;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button1;

    public MainMenu(){
        setContentPane(MainPanel);
        setTitle("Vectors3D");
        setSize(1920,1080);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }


    public void changeScene(ActionEvent event){
        String command = event.getActionCommand();
        if("sumofvec".equals(command)){
            new SumOfVGUI();
        }

    }
}
