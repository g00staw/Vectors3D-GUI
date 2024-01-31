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
        model.addColumn("ID Wektora");
        model.addColumn("Współrzędna X");
        model.addColumn("Współrzędna Y");
        model.addColumn("Współrzędna Z");

        // Ustaw model dla tableOfVectors
        tableOfVectors.setModel(model);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton button = (JRadioButton) e.getSource();
                if(button == DefaultDatabase) {
                    InjectDatabase database = new InjectDatabase("database/UserDatabase.xlsx");
                    List<Vector3D> vectorsFromDatabase = database.readVectorsFromDatabase();
                    if (vectorsFromDatabase != null) {
                        System.out.println("Wektory z bazy danych 1:");
                        for (Vector3D vector : vectorsFromDatabase) {
                            model.addRow(new Object[]{vector.getId(),vector.getX(),vector.getY(),vector.getZ()});
                        }
                    }

                } else {
                    InjectDatabase database = new InjectDatabase("database/3dVecCordINTNUM.xlsx");
                    List<Vector3D> vectorsFromDatabase = database.readVectorsFromDatabase();
                    if (vectorsFromDatabase != null) {
                        System.out.println("Wektory z bazy danych 1:");
                        for (Vector3D vector : vectorsFromDatabase) {
                            model.addRow(new Object[]{vector.getId(),vector.getX(),vector.getY(),vector.getZ()});
                        }
                    }
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
