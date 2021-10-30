package pt.iade.school1.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student extends Person{
    private static int nextNumber = 0;
    private char gender; 
    private int number;
    private ArrayList<Unit> units;
    private ArrayList<Enrolment> enrolments;
    @JsonIgnoreProperties({"student"})
    public Student(String name, LocalDate birthDay,
                   char gender) {
        super(name,birthDay,gender);
        this.number = nextNumber; 
        nextNumber++;
        units=new ArrayList<Unit>();
        enrolments=new ArrayList<Enrolment>();
    }

    @Override
    public String getReference() {
        return "S"+number;
    }

    public static int getNextNumber() { return nextNumber; }
    public String getName() {  return name; } 
    public void setName(String name) { this.name = name; } 
    public LocalDate getBirthDate() { 
        return birthDay;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    } 
    public ArrayList<Unit> getUnits(){
        return units;
    }
    public void enroll(Unit unit){
        units.add(unit);
        unit.getStudents().add(this);
    }
    public ArrayList<Enrolment> getEnrolments(){
        return enrolments;
    }
    public void enroll(Enrolment enrolment){
        enrolments.add(enrolment);
        enrolment.getUnit().getEnrolments().add(enrolment);
    }
}