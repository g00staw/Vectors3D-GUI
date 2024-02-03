import javax.swing.*;
import java.util.List;

public class MultiplyVBySFunc {

    public Vector3D multiplyVectorByScalar(List<Vector3D> givenVectors, boolean print, double multiplier){
        InputData cords = new InputData();
        double x = 0;
        double y = 0;
        double z = 0;
        Vector3D newVector;
        Vector3D temp = givenVectors.get(0);

        SaveLogs saveLogs = new SaveLogs();

        x = temp.getX() * multiplier;
        y = temp.getY() * multiplier;
        z = temp.getZ() * multiplier;


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
