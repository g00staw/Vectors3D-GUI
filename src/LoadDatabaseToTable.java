import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;

public class LoadDatabaseToTable extends JFrame {

    public DefaultTableModel tableWithData(String path) {
        //JTable newTable = new JTable();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Wektora");
        model.addColumn("Współrzędna X");
        model.addColumn("Współrzędna Y");
        model.addColumn("Współrzędna Z");

        InjectDatabase database = new InjectDatabase(path);
        List<Vector3D> vectorsFromDatabase = database.readVectorsFromDatabase();
        int index = 0;
        if (vectorsFromDatabase != null) {
            for (Vector3D vector : vectorsFromDatabase) {
                model.addRow(new Object[]{index, vector.getX(), vector.getY(), vector.getZ()});
                index++;
            }
        }
        return model;
    }

    public DefaultTableModel tableWithAddedVector(List<Vector3D> givenVectors){
        DefaultTableModel model2 = new DefaultTableModel();
        model2.addColumn("ID Wektora");
        model2.addColumn("Współrzędna X");
        model2.addColumn("Współrzędna Y");
        model2.addColumn("Współrzędna Z");
        if (givenVectors != null) {
            for (Vector3D vector : givenVectors) {
                String xString = String.valueOf(vector.getX()).replace(',', '.');
                String yString = String.valueOf(vector.getY()).replace(',', '.');
                String zString = String.valueOf(vector.getZ()).replace(',', '.');

                double x = Double.parseDouble(xString);
                double y = Double.parseDouble(yString);
                double z = Double.parseDouble(zString);

                model2.addRow(new Object[]{vector.getId(), x, y, z});
            }
        }

        return model2;
    }
}
