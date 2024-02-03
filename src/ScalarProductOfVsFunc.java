import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ScalarProductOfVsFunc {
    public Vector3D scalarProductOfGivenVectors(List<Vector3D> givenVectors, boolean print){
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
                    x *= temp.getX();
                    y *= temp.getY();
                    z *= temp.getZ();
                }
            }
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
        }
        else {
            JOptionPane.showMessageDialog(null, "Do przeprowadzenia operacji potrzebne są co najmniej dwa wektory.", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
        newVector = new Vector3D(0, x,y,z);

        if(print == true){
            saveLogs.saveHistory();
            System.out.println("Iloczyn skalarny wektorów: "+givenVectors +" jest równa: ");
            System.out.println("Wektor : "+newVector);
            saveLogs.stopRedirectingConsoleOutput();
        }

        return newVector;
    }
}
