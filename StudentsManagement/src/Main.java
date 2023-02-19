import View.StudentsManagementView;
import Model.*;
import Controller.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getLookAndFeel());
            System.out.println("CC");
            new StudentsManagementView();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}