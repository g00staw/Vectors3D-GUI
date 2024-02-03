import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

        try (BufferedReader reader = new BufferedReader(new FileReader("settings/checkbox_state.txt"))) {
            String line = reader.readLine();
            if (line != null) {
                boolean isChecked = Boolean.parseBoolean(line);
                if(isChecked){
                    RoundedResult roundedResult = new RoundedResult();
                    x = roundedResult.roundOneVar(x);
                    y = roundedResult.roundOneVar(y);
                    z = roundedResult.roundOneVar(z);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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
