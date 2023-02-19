package Model;

public class Date {
    private String date;
    public Date(){
        this.date = "";
    }
    public Date (String index){
        this.date = index;
    }
    public void setDate(String index){
        this.date = index;
    }
    public String getDate(){
        return this.date;
    }
}
