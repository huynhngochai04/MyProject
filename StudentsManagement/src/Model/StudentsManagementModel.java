package Model;

import java.util.ArrayList;

public class StudentsManagementModel {
    public ArrayList<Students> list;
    private String choice;
    private String fileName;

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getChoice() {
        return choice;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public StudentsManagementModel(){
        this.list = new ArrayList<Students>();
        this.choice = "";
        this.fileName="";
    }
    public StudentsManagementModel(ArrayList<Students> index){
        this.list = index;
    }

    public void setList(ArrayList<Students> list) {
        this.list = list;
    }

    public ArrayList<Students> getList() {
        return list;
    }
    public void insert(Students students){
        this.list.add(students);
    }
    public void delete(Students students){
        this.list.remove(students);
    }
    public void update(Students students){
        this.list.remove(students);
        this.list.add(students);
    }

}
