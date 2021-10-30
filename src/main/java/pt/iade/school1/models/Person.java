package pt.iade.school1.models;

import java.time.LocalDate;
import java.util.Collection;

public abstract class Person {
    protected String name;
    protected LocalDate birthDay;
    protected String email;
    protected char gender;

    public Person(String name, LocalDate birthDay, char gender) {
        this.name = name;
        this.birthDay = birthDay;
        this.email = "";
        this.gender = gender;
    }

    public abstract String getReference();

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
