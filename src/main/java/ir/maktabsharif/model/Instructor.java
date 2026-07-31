package ir.maktabsharif.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
//• instructorName (String)
//• email (String)
@Embeddable
public class Instructor {
    @Column(name = "instructor_Name",nullable = false)
    private String instructorName;

    @Column(unique = true,nullable = false)
    private String email;

    public Instructor(String instructorName, String email) {
        this.instructorName = instructorName;
        this.email = email;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorName='" + instructorName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
