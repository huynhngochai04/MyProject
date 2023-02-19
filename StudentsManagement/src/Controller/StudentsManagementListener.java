package Controller;

import Model.City;
import Model.Date;
import Model.Students;
import View.StudentsManagementView;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentsManagementListener implements ActionListener {
    public StudentsManagementView studentsManagementView;
    private Students students;

    public StudentsManagementListener(StudentsManagementView studentsManagementView){
        this.studentsManagementView=studentsManagementView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if (button!="About Me"&&button!="Exit"&&button!="Open"&&button!="Close"&&button!="Delete"){
            JOptionPane.showMessageDialog(studentsManagementView, "Bạn vừa nhấn vào nút: " + button);
        }
        if (button.equals("Insert")) {
            this.studentsManagementView.deleteForm();
            this.studentsManagementView.model.setChoice(button);
        } else {
            try {
                if (button.equals("Ok")) {
                    int id = Integer.parseInt(studentsManagementView.idTextField.getText());
                    String name = studentsManagementView.nameTextFiel.getText();
                    String cityCode = studentsManagementView.comboBoxCityTyping.getSelectedIndex() + "";
                    City city = City.getCityNameById(cityCode);
                    String birthday = studentsManagementView.dateTextFiel.getText();
                    Date date = new Date();
                    date.setDate(birthday);
                    boolean sexCheck = true;
                    if (studentsManagementView.mRadioButton.isSelected()) {
                        sexCheck = true;
                    } else sexCheck = false;
                    double mathPoint = Double.valueOf(studentsManagementView.mathTextFiel.getText());
                    double physicsPoint = Double.valueOf(studentsManagementView.physicalTextFiel.getText());
                    ;
                    double chemistryPoint = Double.valueOf(studentsManagementView.chemistryTextFiel.getText());
                    ;
                    students = new Students(id, name, city, date, sexCheck, mathPoint, physicsPoint, chemistryPoint);
                    studentsManagementView.model.list.add(students);
                    if (this.studentsManagementView.model.getChoice().equals("Edit")) {
                        this.studentsManagementView.updateStudent(students);
                        this.studentsManagementView.deleteForm();
                    } else {
                        this.studentsManagementView.addStudent(students);
                    }
                }
                else {
                    if (button.equals("Edit")){
                        this.studentsManagementView.showStudentInfomation(studentsManagementView);
                        this.studentsManagementView.model.setChoice(button);
                    } else {
                        if (button.equals("Delete")){
                            int choice = JOptionPane.showConfirmDialog(studentsManagementView,
                                    "Bạn có chắc chắn muốn xóa dữ liệu thí sinh này chứ?",
                                    "An Inane Question",
                                    JOptionPane.YES_NO_OPTION);
                            if (choice==JOptionPane.YES_OPTION) {
                                this.studentsManagementView.deleteRowData();
                            }
                        }
                        else {
                            if (button.equals("Cancel")){
                                this.studentsManagementView.undoSelected();
                            }
                            else {
                                if (button.equals("Filtre")){
                                    this.studentsManagementView.searchingInformation();
                                }
                                else {
                                    if (button.equals("Exit")){
                                        System.exit(0);
                                    } else {
                                        if (button.equals("About Me")){
                                            this.studentsManagementView.showAboutProgramming(studentsManagementView);
                                        } else {
                                            if (button.equals("Open")){
                                                this.studentsManagementView.openFile(studentsManagementView);
                                                this.studentsManagementView.refreshTable(studentsManagementView);
                                            }
                                            else {
                                                if (button.equals("Save")){
                                                    this.studentsManagementView.saveFile(studentsManagementView);
                                                    this.studentsManagementView.deleteForm();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    }
                } catch(Exception e2){
                    e2.printStackTrace();
                }
            }
        }
    }
