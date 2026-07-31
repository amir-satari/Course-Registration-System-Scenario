package ir.maktabsharif.model;
//Database Design
//Create the following tables using JPA annotations:
//students table contains:
//• id (SERIAL) – Primary key
//• first_name (VARCHAR) – Student first name
//• last_name (VARCHAR) – Student last name
//• national_code (VARCHAR) – Unique national code
//• email (VARCHAR) – Email address
//courses table contains:
//• id (SERIAL) – Primary key
//• title (VARCHAR) – Course title
//• capacity (INTEGER) – Maximum number of students
//• category (VARCHAR) – Course category (enum)
//• instructor_name (VARCHAR) – Instructor name
//• instructor_email (VARCHAR) – Instructor email
//registrations table contains:
//• id (SERIAL) – Primary key
//• student_id (INTEGER) – Reference to student
//• course_id (INTEGER) – Reference to course
//• registration_date (DATE) – Date of registration
public class BaseModel <ID extends Number>{
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

}
