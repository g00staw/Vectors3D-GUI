import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EditDatabaseGUI extends JFrame{
    private JPanel sumMainP;
    private JPanel panel1;
    private JButton ustawieniaButton;
    private JButton mainMenuButton;
    private JButton back;
    private JTextField xCordADD;
    private JTextField zCordADD;
    private JTextField yCordADD;
    private JButton addVectorButton;
    private JButton editButton;
    private JTable tableOfVectors;
    private JTextField idEDIT;
    private JTextField xCordEDIT;
    private JTextField yCordEDIT;
    private JTextField zCordEDIT;
    private JTextField idREMOVE;
    private JButton removeBUTTON;

    public EditDatabaseGUI(){
        setContentPane(sumMainP);
        setTitle("Vectors3D - Settings");
        setSize(1280,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

        LoadDatabaseToTable newTableWithData2 = new LoadDatabaseToTable();
        tableOfVectors.setModel(newTableWithData2.tableWithData("database/UserDatabase.xlsx"));

        addVectorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try (FileInputStream fis = new FileInputStream("database/UserDatabase.xlsx");
                     Workbook workbook = new XSSFWorkbook(fis)){

                    Sheet sheet = workbook.getSheetAt(0);


                    InputDataFromGUI vectorCords = new InputDataFromGUI();
                    Row firstRow = sheet.getRow(0);
                    if(firstRow == null) {
                        if (vectorCords.getDoubleData(xCordADD.getText()) && vectorCords.getDoubleData(yCordADD.getText()) && vectorCords.getDoubleData(zCordADD.getText())) {

                            Row newRow = sheet.createRow(0);
                            Cell celID = newRow.createCell(0);
                            Cell cellX = newRow.createCell(1);
                            Cell cellY = newRow.createCell(2);
                            Cell cellZ = newRow.createCell(3);

                            celID.setCellValue(0);
                            cellX.setCellValue(Double.parseDouble(xCordADD.getText()));
                            cellY.setCellValue(Double.parseDouble(yCordADD.getText()));
                            cellZ.setCellValue(Double.parseDouble(zCordADD.getText()));

                            FileOutputStream fos = new FileOutputStream("database/UserDatabase.xlsx");
                            workbook.write(fos);
                            fos.close();

                            JOptionPane.showMessageDialog(null, "Wektor został dodany", "Informacja", JOptionPane.INFORMATION_MESSAGE);
                            LoadDatabaseToTable newTableWithData2 = new LoadDatabaseToTable();
                            tableOfVectors.setModel(newTableWithData2.tableWithData("database/UserDatabase.xlsx"));
                        } else {
                            JOptionPane.showMessageDialog(null, "Błąd danych.", "Błąd.", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    else{
                        if (vectorCords.getDoubleData(xCordADD.getText()) && vectorCords.getDoubleData(yCordADD.getText()) && vectorCords.getDoubleData(zCordADD.getText())) {

                            int lastIndex = sheet.getLastRowNum();
                            Row newRow = sheet.createRow(lastIndex + 1); // Tworzenie nowego wiersza

                            Cell celID = newRow.createCell(0);
                            Cell cellX = newRow.createCell(1);
                            Cell cellY = newRow.createCell(2);
                            Cell cellZ = newRow.createCell(3);

                            celID.setCellValue(lastIndex+1);
                            cellX.setCellValue(Double.parseDouble(xCordADD.getText()));
                            cellY.setCellValue(Double.parseDouble(yCordADD.getText()));
                            cellZ.setCellValue(Double.parseDouble(zCordADD.getText()));

                            FileOutputStream fos = new FileOutputStream("database/UserDatabase.xlsx");
                            workbook.write(fos);
                            fos.close();

                            JOptionPane.showMessageDialog(null, "Wektor został dodany", "Informacja", JOptionPane.INFORMATION_MESSAGE);
                            LoadDatabaseToTable newTableWithData2 = new LoadDatabaseToTable();
                            tableOfVectors.setModel(newTableWithData2.tableWithData("database/UserDatabase.xlsx"));
                        } else {
                            JOptionPane.showMessageDialog(null, "Błąd danych.", "Błąd.", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }


                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (FileInputStream fis = new FileInputStream("database/UserDatabase.xlsx");
                     Workbook workbook = new XSSFWorkbook(fis)){

                    Sheet sheet = workbook.getSheetAt(0);
                    InputDataFromGUI vectorCords = new InputDataFromGUI();

                    if (vectorCords.getIntData(idEDIT.getText()) && vectorCords.getDoubleData(yCordEDIT.getText()) && vectorCords.getDoubleData(zCordEDIT.getText())) {
                        int id = Integer.parseInt(idEDIT.getText());
                        if(id > 0 && id <= sheet.getLastRowNum()){
                            Row selectedRow = sheet.getRow(id);
                            Cell celID = selectedRow.getCell(0);
                            Cell cellX = selectedRow.getCell(1);
                            Cell cellY = selectedRow.getCell(2);
                            Cell cellZ = selectedRow.getCell(3);

                            celID.setCellValue(id);
                            cellX.setCellValue(Double.parseDouble(xCordEDIT.getText()));
                            cellY.setCellValue(Double.parseDouble(yCordEDIT.getText()));
                            cellZ.setCellValue(Double.parseDouble(zCordEDIT.getText()));

                            FileOutputStream fos = new FileOutputStream("database/UserDatabase.xlsx");
                            workbook.write(fos);
                            fos.close();
                            JOptionPane.showMessageDialog(null, "Wektor został zmodyfikowany.", "Informacja", JOptionPane.INFORMATION_MESSAGE);

                            LoadDatabaseToTable newTableWithData2 = new LoadDatabaseToTable();
                            tableOfVectors.setModel(newTableWithData2.tableWithData("database/UserDatabase.xlsx"));
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Błędny indeks.", "Błąd.", JOptionPane.INFORMATION_MESSAGE);
                        }


                    } else {
                        JOptionPane.showMessageDialog(null, "Błąd danych.", "Błąd.", JOptionPane.INFORMATION_MESSAGE);
                    }



                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        removeBUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (FileInputStream fis = new FileInputStream("database/UserDatabase.xlsx");
                     Workbook workbook = new XSSFWorkbook(fis)){

                    Sheet sheet = workbook.getSheetAt(0);
                    InputDataFromGUI vectorCords = new InputDataFromGUI();

                    if (vectorCords.getIntData(idREMOVE.getText())) {
                        int id = Integer.parseInt(idREMOVE.getText());
                        Row rowToRemove = sheet.getRow(id);
                        if(id >= 0 && id <= sheet.getLastRowNum() && rowToRemove != null){

                            sheet.removeRow(rowToRemove);

                            if (id >= 0 && id < sheet.getLastRowNum()) {
                                sheet.shiftRows(id + 1, sheet.getLastRowNum(), -1);
                            }

                            FileOutputStream fos = new FileOutputStream("database/UserDatabase.xlsx");
                            workbook.write(fos);
                            fos.close();
                            JOptionPane.showMessageDialog(null, "Wektor został usunięty.", "Informacja", JOptionPane.INFORMATION_MESSAGE);

                            LoadDatabaseToTable newTableWithData2 = new LoadDatabaseToTable();
                            tableOfVectors.setModel(newTableWithData2.tableWithData("database/UserDatabase.xlsx"));
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Błędny indeks.", "Błąd.", JOptionPane.INFORMATION_MESSAGE);
                        }


                    } else {
                        JOptionPane.showMessageDialog(null, "Błąd.", "Błąd.", JOptionPane.INFORMATION_MESSAGE);
                    }



                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        ustawieniaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new settingsGUI();
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new settingsGUI();
            }
        });

        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainMenu();
            }
        });




    }

}
