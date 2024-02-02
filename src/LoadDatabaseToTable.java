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
        if (vectorsFromDatabase != null) {
            for (Vector3D vector : vectorsFromDatabase) {
                model.addRow(new Object[]{vector.getId(), vector.getX(), vector.getY(), vector.getZ()});
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
                model2.addRow(new Object[]{vector.getId(), vector.getX(), vector.getY(), vector.getZ()});
            }
        }

        return model2;
    }
}
