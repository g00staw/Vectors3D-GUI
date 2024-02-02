import javax.swing.*;
import java.util.List;

public class SubtractionFunc {
    public Vector3D subOfGivenVectors(List<Vector3D> givenVectors, boolean print){
        InputData cords = new InputData();
        double x = 0;
        double y = 0;
        double z = 0;
        double[][] result = new double[1][3];
        Vector3D newVector;
        Vector3D temp;

        SaveLogs saveLogs = new SaveLogs();

        if (givenVectors.size() > 1) {
            for(int i=0;i<givenVectors.size();i++){
                if(i == 0){
                    temp = givenVectors.get(i);
                    x = temp.getX();
                    y = temp.getY();
                    z = temp.getZ();
                }
                else {
                    temp = givenVectors.get(i);
                    x -= temp.getX();
                    y -= temp.getY();
                    z -= temp.getZ();
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Do przeprowadzenia operacji potrzebne są co najmniej dwa wektory.", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        newVector = new Vector3D(0, x,y,z);

        if(print == true){
            saveLogs.saveHistory();
            System.out.println("Różnica wektorów: "+givenVectors +" jest równa: ");
            System.out.println("Wektor : "+newVector);
            saveLogs.stopRedirectingConsoleOutput();
        }

        return newVector;
    }
}
