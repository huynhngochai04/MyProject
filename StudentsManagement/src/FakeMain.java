import View.StudentsManagementView;
import Model.*;
import Controller.*;
import javax.swing.*;

public class FakeMain {
    public static void main(String[] args) {
        try{
            StudentsManagementView.main(args);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
