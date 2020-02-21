package xeus.model;

import java.util.GregorianCalendar;

/**
 * The class for holding a person's data.
 */
public class Person {

    private String firstName;
    private String secondName;
    private String lastName;
    private String academicTitle;
    private GregorianCalendar dateOfBirth;
    private GregorianCalendar dateOfDeath;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAcademicTitle() {
        return academicTitle;
    }

    public void setAcademicTitle(String academicTitle) {
        this.academicTitle = academicTitle;
    }

    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(GregorianCalendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public GregorianCalendar getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(GregorianCalendar dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }
}