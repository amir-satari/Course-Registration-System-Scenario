package ir.maktabsharif.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends BaseModel<Long> {

    @Column(name = "first_name",nullable = false,length = 50)
    private String firstName;
    @Column(name = "last_name",nullable = false,length = 50)
    private String lastName;
    @Column(name = "national_code",unique = true,nullable = false,length = 50)
    private String nationalCode;
    @Column(unique = true,nullable = false)
    private String email;

    public Student(String firstName, String lastName, String nationalCode, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.email = email;
    }


    public Student() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
