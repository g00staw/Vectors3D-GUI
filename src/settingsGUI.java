import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class settingsGUI extends JFrame{
    private JPanel panel1;
    private JButton back;
    private JButton button1;
    private JButton createDatabaseButton;
    private JButton EditDatabaseButton;
    private JCheckBox roundResultsButton;
    private JPanel settingsPanel;

    public settingsGUI(){
        setContentPane(settingsPanel);
        setTitle("Vectors3D - Settings");
        setSize(1280,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);


        createDatabaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("database/UserDatabase.xlsx");
                if (file.exists()) {
                    JOptionPane.showMessageDialog(null, "Baza danych jest już utworzona! Nastąpi przekierowanie do jej edycji!", "UWAGA!", JOptionPane.WARNING_MESSAGE);
                    dispose();
                    new EditDatabaseGUI();
                }
                else {

                    Workbook workbook = new XSSFWorkbook();
                    Sheet sheet = workbook.createSheet("UserDatabase");
                    try {
                        FileOutputStream fos = new FileOutputStream("database/UserDatabase.xlsx");
                        workbook.write(fos);
                        fos.close();
                        JOptionPane.showMessageDialog(null, "Baza danych została utworzona! Nastąpi przekierowanie do jej uzupełnienia / edycji.", "Uwaga!", JOptionPane.INFORMATION_MESSAGE);
                        new EditDatabaseGUI();
                        dispose();
                    } catch (IOException er) {
                        er.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Wystąpił błąd przy tworzeniu bazy.", "Uwaga!", JOptionPane.INFORMATION_MESSAGE);
                    }

                }
            }
        });

        EditDatabaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new EditDatabaseGUI();
            }
        });
    }
}
