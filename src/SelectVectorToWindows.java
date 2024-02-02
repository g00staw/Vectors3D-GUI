import javax.swing.*;

public class SelectVectorToWindows {

    private static String id;
    private static String x;
    private static String y;
    private static String z;


    public void getVectorsData(int selectedRow, JTable tableOfVectors){
        if (selectedRow >= 0) {
            // Pobierz dane z zaznaczonego wiersza i ustaw je jako tekst JTextField
            id = tableOfVectors.getValueAt(selectedRow, 0).toString();
            x = tableOfVectors.getValueAt(selectedRow, 1).toString();
            y = tableOfVectors.getValueAt(selectedRow, 2).toString();
            z = tableOfVectors.getValueAt(selectedRow, 3).toString();
        }
    }

    public String getX(int selectedRow, JTable tableOfVectors){
        if (selectedRow >= 0) {
            return tableOfVectors.getValueAt(selectedRow, 1).toString();
        }
        return null;
    }
    public String getY(int selectedRow, JTable tableOfVectors){
        if (selectedRow >= 0) {
            return tableOfVectors.getValueAt(selectedRow, 2).toString();
        }
        return null;
    }
    public String getZ(int selectedRow, JTable tableOfVectors){
        if (selectedRow >= 0) {
            return tableOfVectors.getValueAt(selectedRow, 3).toString();
        }
        return null;
    }


}
