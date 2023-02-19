package View;

import Controller.StudentsManagementListener;
import Model.City;
import Model.Students;
import Model.StudentsManagementModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

public class StudentsManagementView extends JFrame {
    public StudentsManagementModel model;
    public JScrollPane jScrollPane;
    public JPanel panelMain;
    private JFileChooser fc = new JFileChooser();

    public JMenuBar menuBar1;
    public JMenu fileMenu;
    public JMenu aboutMenu;
    public JTabbedPane tablePanel;
    public JTextField idTextField;
    public JTextField nameTextFiel;
    public JComboBox comboBoxCityTyping;
    public JTextField dateTextFiel;
    public JTextField totalTextFiel;
    public JTextField mathTextFiel;
    public JTextField physicalTextFiel;
    public JTextField chemistryTextFiel;
    public JButton insertButton;
    public JButton deleteButton;
    public JButton editButton;
    public JButton okButton;
    public JButton cancelButton;
    public JComboBox cityComboBoxSelect;
    public JTextField idFiltre;
    public JButton filtreButton;
    public JTable table;
    public JTable tableData;
    public JPanel tableControl;
    public JRadioButton mRadioButton;
    public JRadioButton fRadioButton;
    public ButtonGroup sexChoice;
    public JTable tableStudents;
    private JTabbedPane tablePanelFiltre;
    private JTable tableFiltre;
    private JScrollPane jScrollPaneFiltre;
    private Vector listDataFiltre = new Vector();
    private JPanel jPanelFiltre;
    private JPanel jPanelFirstFiltre;
    public JScrollPane jScrollPaneMain;
    public Vector listData = new Vector();

    public StudentsManagementView (){
        this.model = new StudentsManagementModel();
        this.sexChoice = new ButtonGroup();
        this.sexChoice.add(this.mRadioButton);
        this.sexChoice.add(this.fRadioButton);
    }
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getLookAndFeel());
            StudentsManagementView view = new StudentsManagementView();
            ActionListener actionListener = new StudentsManagementListener(view);
            view.setContentPane(view.panelMain);
            view.createTable(view);
            //-----------AddActionListener--------------
            view.cancelButton.addActionListener(actionListener);
            view.cancelButton.setIcon(new ImageIcon());
            view.insertButton.addActionListener(actionListener);
            view.okButton.addActionListener(actionListener);
            view.filtreButton.addActionListener(actionListener);
            view.editButton.addActionListener(actionListener);
            view.deleteButton.addActionListener(actionListener);
            //--------------JMenuItem---------------------
            JMenuItem jMenuItemOpen = new JMenuItem("Open");
            jMenuItemOpen.addActionListener(actionListener);
            jMenuItemOpen.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("open_icon.png"))));
            JMenuItem jMenuItemSave = new JMenuItem("Save");
            jMenuItemSave.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("save_icon.png"))));
            jMenuItemSave.addActionListener(actionListener);
            JMenuItem jMenuItemExit = new JMenuItem("Exit");
            jMenuItemExit.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("exit_icon.png"))));
            jMenuItemExit.addActionListener(actionListener);

            JMenuItem jMenuItemAboutMe = new JMenuItem("About Me");
            jMenuItemAboutMe.addActionListener(actionListener);
            jMenuItemAboutMe.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("aboutme_icon.png"))));

            //------------FileMenu----------------
            view.fileMenu.add(jMenuItemOpen);
            view.fileMenu.add(jMenuItemSave);
            view.fileMenu.addSeparator();
            view.fileMenu.add(jMenuItemExit);
            //------------OpenMenu------------------
            view.aboutMenu.add(jMenuItemAboutMe);
            //-----Combo Box City --------------------------
            ArrayList<City> listCity = City.getListCity();
            view.cityComboBoxSelect.addItem("");
            view.comboBoxCityTyping.addItem("");
            for (City city : listCity){
                view.cityComboBoxSelect.addItem(city.getCityName());
                view.comboBoxCityTyping.addItem(city.getCityName());
            }
            //------------------Button Group Sex-------------------
            //-------------------
            //----------------------------------------------------------
            view.setTitle("Students Management");
            view.setSize(1000,800);
            view.setLocationRelativeTo(null);
            view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            view.setVisible(true);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteForm(){
        idTextField.setText("");
        nameTextFiel.setText("");
        dateTextFiel.setText("");
        mathTextFiel.setText("");
        physicalTextFiel.setText("");
        chemistryTextFiel.setText("");
        comboBoxCityTyping.setSelectedIndex(-1);
        sexChoice.clearSelection();

    }
    public void createTable(StudentsManagementView view){
        Vector header = new Vector();
        header.add("ID");
        header.add("Name");
        header.add("City");
        header.add("Date");
        header.add("Sex");
        header.add("Math");
        header.add("Physical");
        header.add("Chemistry");
        Vector data = new Vector();

        Vector row1 = new Vector();

        table = new JTable(data,header);
        tableFiltre = new JTable(data, header);
        tableData = new JTable(data,header);

        tablePanel.remove(tableControl);
        tablePanelFiltre.remove(jPanelFiltre);

        jScrollPane = new JScrollPane(table);
        jScrollPaneFiltre = new JScrollPane(tableFiltre);

        tablePanel.add("List Students", jScrollPane);
        tablePanelFiltre.add("List Filtre", jScrollPaneFiltre);
    }
    public void addStudent(Students students){
        this.model.insert(students);
        int row = tableData.getRowCount();
        int column = tableData.getColumnCount();
        Vector header = new Vector();
        header.add("ID");
        header.add("Name");
        header.add("City");
        header.add("Date");
        header.add("Sex");
        header.add("Math");
        header.add("Physical");
        header.add("Chemistry");
        Vector newRow = new Vector();
        Vector data = new Vector();
        int count=0;
        Vector cloneListData = new Vector();
        cloneListData =(Vector) listData.clone();
        while(!cloneListData.isEmpty()){
            data.add(cloneListData.get(count));
            cloneListData.removeElementAt(count);
        }
        newRow.add(students.getId()+"");
        newRow.add(students.getName());
        newRow.add(students.getCity().getCityName());
        newRow.add(students.getDate());
        String sexual ="";
        if (students.getSex()){
            sexual = "Male";
        } else sexual="Female";
        newRow.add(sexual);
        newRow.add(students.getMathPoint()+"");
        newRow.add(students.getPhysicsPoint()+"");
        newRow.add(students.getChemistryPoint()+"");
        data.add(newRow);
        listData.add(newRow);

        tablePanel.remove(jScrollPane);

        table = new JTable(listData,header);

        jScrollPane = new JScrollPane(table);

        tablePanel.add("List Students", jScrollPane);

    }
    public void updateStudent(Students students){
        int row = table.getSelectedRow();
        int count = 0;
                Vector clone = new Vector();
                clone.add(students.getId()+"");
                clone.add(students.getName());
                clone.add(students.getCity().getCityName());
                clone.add(students.getDate());
                String sexual ="";
                if (students.getSex()){
                    sexual = "Male";
                } else sexual="Female";
                clone.add(sexual);
                clone.add(students.getMathPoint()+"");
                clone.add(students.getPhysicsPoint()+"");
                clone.add(students.getChemistryPoint()+"");
                listData.remove(row);
                listData.add(row,clone);

                Vector header = new Vector();
                header.add("ID");
                header.add("Name");
                header.add("City");
                header.add("Date");
                header.add("Sex");
                header.add("Math");
                header.add("Physical");
                header.add("Chemistry");

        table = new JTable(listData,header);

        tablePanel.remove(jScrollPane);

        jScrollPane = new JScrollPane(table);

        tablePanel.add("List Students", jScrollPane);
    }
    public void showStudentInfomation(StudentsManagementView view) {
        int row = table.getSelectedRow();
        String id = table.getValueAt(row,0)+"";
        String name = table.getValueAt(row,1)+"";
        City city = City.getCityByName(table.getValueAt(row,2)+"");
        String birthday = table.getValueAt(row,3)+"";
        String choiceSex = table.getValueAt(row,4)+"";
        if (choiceSex.equals("Male")) {
            mRadioButton.setSelected(true);
            fRadioButton.setSelected(false);
        } else {
            fRadioButton.setSelected(true);
            mRadioButton.setSelected(false);
        }
        double mathPoint = Double.valueOf(table.getValueAt(row,5)+"");
        double physicsPoint =Double.valueOf(table.getValueAt(row,6)+"");
        double chemistryPoint = Double.valueOf(table.getValueAt(row,7)+"");

        view.idTextField.setText(id);
        view.nameTextFiel.setText(name);
        view.comboBoxCityTyping.setSelectedItem(city.getCityName());
        view.dateTextFiel.setText(birthday);
        view.mathTextFiel.setText(mathPoint+"");
        view.physicalTextFiel.setText(physicsPoint+"");
        view.chemistryTextFiel.setText(chemistryPoint+"");
    }

    public void deleteRowData() {
        int row = table.getSelectedRow();
        int count =0;
        listData.remove(row);
        Vector header = new Vector();
        header.add("ID");
        header.add("Name");
        header.add("City");
        header.add("Date");
        header.add("Sex");
        header.add("Math");
        header.add("Physical");
        header.add("Chemistry");

        table = new JTable(listData,header);

        tablePanel.remove(jScrollPane);

        jScrollPane = new JScrollPane(table);

        tablePanel.add("List Students", jScrollPane);
    }

    public void undoSelected() {
        Vector header = new Vector();
        header.add("ID");
        header.add("Name");
        header.add("City");
        header.add("Date");
        header.add("Sex");
        header.add("Math");
        header.add("Physical");
        header.add("Chemistry");

        table = new JTable(listData, header);

        tablePanel.remove(jScrollPane);

        jScrollPane = new JScrollPane(table);

        tablePanel.add("List Students", jScrollPane);
    }

    public void searchingInformation() {
        String cityCode = cityComboBoxSelect.getSelectedIndex()+"";
        City citySelected = City.getCityNameById(cityCode);
        if (citySelected.getCityName()!=null && idFiltre.getText().equals("")) {
            String cityNameSelected = citySelected.getCityName();
            Vector cloneListData = new Vector();
            cloneListData = (Vector) listData.clone();
            int row = 0;
            listDataFiltre.clear();
            int check = 0;
            while(!cloneListData.isEmpty()){
                Vector clone = new Vector();
                clone = (Vector) cloneListData.get(row);
                if (clone.elementAt(2).equals(cityNameSelected)){
                    listDataFiltre.add(clone);
                    check++;
                }
                cloneListData.remove(row);
            }
            Vector header = new Vector();
            header.add("ID");
            header.add("Name");
            header.add("City");
            header.add("Date");
            header.add("Sex");
            header.add("Math");
            header.add("Physical");
            header.add("Chemistry");

            Vector data = new Vector();

            if (check!=0 ){
                tableFiltre = new JTable(listDataFiltre,header);
            } else {
                tableFiltre = new JTable(data,header);
            }

            tablePanelFiltre.remove(jScrollPaneFiltre);

            jScrollPaneFiltre = new JScrollPane(tableFiltre);

            tablePanelFiltre.add("List Filtre", jScrollPaneFiltre);

        } else {
            if (idFiltre.getText()!=""  && citySelected.getCityName()==null){
                Vector cloneListData = new Vector();
                listDataFiltre.clear();
                cloneListData = (Vector) listData.clone();
                String idSearching = idFiltre.getText();
                int row = 0;
                int check =0;
                while(!cloneListData.isEmpty()){
                    Vector clone  = new Vector();
                    clone = (Vector) cloneListData.get(row);
                    if (clone.elementAt(0).equals(idSearching+"")){
                        listDataFiltre.add(clone);
                        check++;
                    }
                    cloneListData.remove(row);
                }
                Vector header = new Vector();
                header.add("ID");
                header.add("Name");
                header.add("City");
                header.add("Date");
                header.add("Sex");
                header.add("Math");
                header.add("Physical");
                header.add("Chemistry");

                Vector data = new Vector();

                if (check!=0 ){
                    tableFiltre = new JTable(listDataFiltre,header);
                } else {
                    tableFiltre = new JTable(data,header);
                }

                tablePanelFiltre.remove(jScrollPaneFiltre);

                jScrollPaneFiltre = new JScrollPane(tableFiltre);

                tablePanelFiltre.add("List Filtre", jScrollPaneFiltre);

            } else {
                if (idFiltre.getText()!="" && citySelected.getCityName() != null){
                    Vector cloneListData = new Vector();
                    cloneListData = (Vector) listData.clone();
                    String idSearching = idFiltre.getText();
                    int row = 0;
                    int check =0;
                    listDataFiltre.clear();
                    while(!cloneListData.isEmpty()){
                        Vector clone  = new Vector();
                        clone = (Vector) cloneListData.get(row);
                        if (clone.elementAt(0).equals(idSearching+"")&&clone.elementAt(2).equals(citySelected.getCityName())){
                            listDataFiltre.add(clone);
                            check++;
                        }
                        cloneListData.remove(row);
                    }
                    Vector header = new Vector();
                    header.add("ID");
                    header.add("Name");
                    header.add("City");
                    header.add("Date");
                    header.add("Sex");
                    header.add("Math");
                    header.add("Physical");
                    header.add("Chemistry");

                    Vector data = new Vector();

                    if (check!=0 ){
                        tableFiltre = new JTable(listDataFiltre,header);
                    } else {
                        tableFiltre = new JTable(data,header);
                    }

                    tablePanelFiltre.remove(jScrollPaneFiltre);

                    jScrollPaneFiltre = new JScrollPane(tableFiltre);

                    tablePanelFiltre.add("List Filtre", jScrollPaneFiltre);

                } else {
                    Vector header = new Vector();
                    header.add("ID");
                    header.add("Name");
                    header.add("City");
                    header.add("Date");
                    header.add("Sex");
                    header.add("Math");
                    header.add("Physical");
                    header.add("Chemistry");

                    Vector data = new Vector();

                    tableFiltre = new JTable(data,header);

                    tablePanelFiltre.remove(jScrollPaneFiltre);

                    jScrollPaneFiltre = new JScrollPane(tableFiltre);

                    tablePanelFiltre.add("List Filtre", jScrollPaneFiltre);
                }
            }
        }
    }

    public void showAboutProgramming(StudentsManagementView view) {
        JOptionPane.showMessageDialog(view,
                "Made by: Hải Code Dạo",
                "Information",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void saveFile(StudentsManagementView view) throws IOException {
        int select = fc.showSaveDialog(view);
        Vector header = new Vector();
        header.add("ID");
        header.add("Name");
        header.add("City");
        header.add("Date");
        header.add("Sex");
        header.add("Math");
        header.add("Physical");
        header.add("Chemistry");
        try {
            if (select == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                OutputStream os = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(os);
                oos.writeObject(listData);
                listData.clear();
                table = new JTable(null,header);

                tablePanel.remove(jScrollPane);

                jScrollPane = new JScrollPane(table);

                tablePanel.add("List Students",jScrollPane);
                oos.flush();
                oos.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void openFile(StudentsManagementView view) throws IOException, ClassNotFoundException {
        int select = fc.showOpenDialog(view);
        Students students = null;
            if (select == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = fc.getSelectedFile();
                    FileInputStream f = new FileInputStream(file.getAbsolutePath());
                    ObjectInputStream inStream = new ObjectInputStream(f);
                    listData =(Vector) inStream.readObject();
                    System.out.println(listData);
                    inStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }

    public void refreshTable(StudentsManagementView studentsManagementView) {
        Vector header = new Vector();
        header.add("ID");
        header.add("Name");
        header.add("City");
        header.add("Date");
        header.add("Sex");
        header.add("Math");
        header.add("Physical");
        header.add("Chemistry");

         Vector data = new Vector();

         table = new JTable((Vector) listData,header);

         tablePanel.remove(jScrollPane);

         jScrollPane = new JScrollPane(table);

         tablePanel.add("List Students",jScrollPane);
    }
}
