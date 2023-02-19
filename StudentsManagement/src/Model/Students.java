package Model;

import java.io.Serializable;

public class Students implements Serializable {
    private int id;
    private String name;
    private City city;
    private Date date;
    private boolean sex;
    private double mathPoint;
    private double physicsPoint;
    private double chemistryPoint;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Students(){

    }

    public Students(int id, String name, City city, Date date, boolean sex, double mathPoint, double physicsPoint, double chemistryPoint) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.date = date;
        this.sex = sex;
        this.mathPoint = mathPoint;
        this.physicsPoint = physicsPoint;
        this.chemistryPoint = chemistryPoint;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setMathPoint(double mathPoint) {
        this.mathPoint = mathPoint;
    }

    public void setPhysicsPoint(double physicsPoint) {
        this.physicsPoint = physicsPoint;
    }

    public void setChemistryPoint(double chemistryPoint) {
        this.chemistryPoint = chemistryPoint;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }

    public String getDate() {
        return date.getDate();
    }

    public boolean getSex() {
        return sex;
    }

    public double getMathPoint() {
        return mathPoint;
    }

    public double getPhysicsPoint() {
        return physicsPoint;
    }

    public double getChemistryPoint() {
        return chemistryPoint;
    }
}
