import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SumFunc {

    public Vector3D sumOfGivenVectors(List<Vector3D> givenVectors, boolean print){
        InputData cords = new InputData();
        double x = 0;
        double y = 0;
        double z = 0;
        double[][] result = new double[1][3];
        Vector3D newVector;

        SaveLogs saveLogs = new SaveLogs();

        if (givenVectors.size() > 1) {
            for (Vector3D vector : givenVectors) {
                x += vector.getX();
                y += vector.getY();
                z += vector.getZ();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Do przeprowadzenia operacji potrzebne są co najmniej dwa wektory.", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        newVector = new Vector3D(0, x,y,z);

        if(print == true){
            saveLogs.saveHistory();
            System.out.println("Suma wektorów: "+givenVectors +" jest równa: ");
            System.out.println("Wektor : "+newVector);
            saveLogs.stopRedirectingConsoleOutput();
        }

        return newVector;
    }
}
