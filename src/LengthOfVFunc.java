import java.util.List;

public class LengthOfVFunc {
    public double LengthOfVector(List<Vector3D> givenVectors, boolean print) {
        InputData cords = new InputData();
        double x = 0;
        double y = 0;
        double z = 0;
        Vector3D temp = givenVectors.get(0);

        SaveLogs saveLogs = new SaveLogs();

        x = temp.getX();
        y = temp.getY();
        z = temp.getZ();

        double finalLenght = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));

        if (print == true) {
            saveLogs.saveHistory();
            System.out.println("Długość wektora: " + givenVectors + " jest równa: ");
            System.out.println("Wektor : " + finalLenght);
            saveLogs.stopRedirectingConsoleOutput();
        }

        return finalLenght;
    }
}
