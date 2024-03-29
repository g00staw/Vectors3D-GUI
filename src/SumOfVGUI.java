import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SumOfVGUI extends JFrame {
    private JPanel SumOfVGUI;
    private JPanel sumMainP;
    private JPanel panel1;
    private JButton ustawieniaButton;
    private JButton back;
    private JButton mainMenuButton;
    private JTable tableOfVectors;
    private JRadioButton UserDatabase;
    private JButton saveLogsButton;
    private JButton clearButton;
    private JButton calculateButton;
    private JRadioButton DefaultDatabase;
    private JTextField xCord;
    private JTextField yCord;
    private JTextField zCord;
    private JTable addedVectorsTable;
    private JButton addVectorButton;
    private JLabel scoreLabel;


    public SumOfVGUI(){

        setContentPane(sumMainP);
        setTitle("Vectors3D - Sum of vectors");
        setSize(1280,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
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

        tableOfVectors.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                int selectedRow = tableOfVectors.getSelectedRow();
                SelectVectorToWindows selectVector = new SelectVectorToWindows();
                xCord.setText(selectVector.getX(selectedRow,tableOfVectors));
                yCord.setText(selectVector.getY(selectedRow,tableOfVectors));
                zCord.setText(selectVector.getX(selectedRow,tableOfVectors));
            }
        });

        List<Vector3D> givenVectors = new ArrayList<>();
        addVectorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InputDataFromGUI vectorCords = new InputDataFromGUI();
                if(vectorCords.getDoubleData(xCord.getText()) && vectorCords.getDoubleData(yCord.getText()) && vectorCords.getDoubleData(zCord.getText())){
                    LoadDatabaseToTable newTableWithData3 = new LoadDatabaseToTable();
                    Vector3D vector;
                    double x = Double.parseDouble(xCord.getText());
                    double y = Double.parseDouble(yCord.getText());
                    double z = Double.parseDouble(zCord.getText());
                    int id = givenVectors.size();
                    vector = new Vector3D(id, x,y,z);
                    givenVectors.add(vector);
                    addedVectorsTable.setModel(newTableWithData3.tableWithAddedVector(givenVectors));
                }
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SumFunc scoreSUM = new SumFunc();
                Vector3D productVector = scoreSUM.sumOfGivenVectors(givenVectors, false);
                scoreLabel.setText("X: "+productVector.getX()+" Y: "+productVector.getY()+" Z: "+productVector.getZ());
            }
        });

        saveLogsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (givenVectors.size() > 1) {
                    SumFunc scoreSUM = new SumFunc();
                    Vector3D productVector = scoreSUM.sumOfGivenVectors(givenVectors, true);
                    scoreLabel.setText("X: "+productVector.getX()+" Y: "+productVector.getY()+" Z: "+productVector.getZ());
                }
               else {
                    JOptionPane.showMessageDialog(null, "Do przeprowadzenia operacji potrzebne są co najmniej dwa wektory.", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xCord.setText("");
                yCord.setText("");
                zCord.setText("");
                givenVectors.clear();
                LoadDatabaseToTable newTableWithData3 = new LoadDatabaseToTable();
                addedVectorsTable.setModel(newTableWithData3.tableWithAddedVector(givenVectors));
                scoreLabel.setText("[ Vector ] X: 0; Y: 0; Z: 0;");


            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainMenu();
            }
        });

        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainMenu();
            }
        });

        ustawieniaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new settingsGUI();
            }
        });




    }
    public static void launchSumOfVGUI(){
        SumOfVGUI sumOfVGUI = new SumOfVGUI();
        sumOfVGUI.setVisible(true);
    }


}
