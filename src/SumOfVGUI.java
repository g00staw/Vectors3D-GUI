import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SumOfVGUI extends JFrame {
    private JPanel SumOfVGUI;
    private JPanel sumMainP;
    private JPanel panel1;
    private JButton ustawieniaButton;
    private JButton back;
    private JButton button1;
    private JTable tableOfVectors;
    private JRadioButton UserDatabase;
    private JButton zapiszButton;
    private JButton wyczyśćButton;
    private JButton obliczButton;
    private JRadioButton DefaultDatabase;


    public SumOfVGUI(){

        setContentPane(sumMainP);
        setTitle("Vectors3D - Sum of vectors");
        setSize(1280,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        DefaultTableModel model = new DefaultTableModel();

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton button = (JRadioButton) e.getSource();
                if(button == UserDatabase) {
                    LoadDatabaseToTable newTableWithData = new LoadDatabaseToTable();
                    tableOfVectors.setModel(newTableWithData.tableWithData("database/UserDatabase.xlsx"));


                } else {
                    LoadDatabaseToTable newTableWithData2 = new LoadDatabaseToTable();
                    tableOfVectors.setModel(newTableWithData2.tableWithData("database/3dVecCordINTNUM.xlsx"));
                }
            }
        };
        DefaultDatabase.addActionListener(listener);
        UserDatabase.addActionListener(listener);


    }
    public static void launchSumOfVGUI(){
        SumOfVGUI sumOfVGUI = new SumOfVGUI();
        sumOfVGUI.setVisible(true);
    }
}
