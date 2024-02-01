import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

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
}
