import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    private JPanel MainPanel;
    private JButton ustawieniaButton;
    private JButton wróćButton;

    public MainMenu(){
        setContentPane(MainPanel);
        setTitle("Vectors3D");
        setSize(1920,1080);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
