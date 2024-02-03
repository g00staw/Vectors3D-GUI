import javax.swing.*;

public class InputDataFromGUI implements DataInterfaceGUI {

    public boolean getDoubleData(String data){
        double var=0;
        boolean validInput = false;
        String givenData = "";
        try{
            var = Double.parseDouble(data);
            validInput = true;
        }
        catch (NumberFormatException e){
            System.out.println("-- Bledny format danych.\n-- Sprobuj ponownie.");
            JOptionPane.showMessageDialog(null, "Wprowadzone dane są nieprawidłowe, proszę spróbować ponownie", "Błąd", JOptionPane.ERROR_MESSAGE);
        }


        return validInput;
    }

    public boolean getIntData(String data){
        int var;
        boolean validInput = false;
        try{
            var = Integer.parseInt(data);
            validInput = true;
        }
        catch (NumberFormatException e){
            System.out.println("-- Bledny format danych.\n-- Sprobuj ponownie.");
            JOptionPane.showMessageDialog(null, "Wprowadzone dane są nieprawidłowe, proszę spróbować ponownie", "Błąd", JOptionPane.ERROR_MESSAGE);
        }


        return validInput;
    }
}
