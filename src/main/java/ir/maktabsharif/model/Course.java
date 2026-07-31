package ir.maktabsharif.model;

import ir.maktabsharif.model.enums.Category;
import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course extends BaseModel<Long>{

    @Column(nullable = false,length = 50)
    private String title;
    @Column(nullable = false,columnDefinition = "check(capacity > 0)")

    private Integer capacity;
    @Enumerated(EnumType.STRING)
    private Category category;

    @Embedded
    private Instructor instructor;


    public Course(String title, Integer capacity, Category category, Instructor instructor) {
        this.title = title;
        this.capacity = capacity;
        this.category = category;
        this.instructor = instructor;
    }

    public Course() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "course{" +
                "title='" + title + '\'' +
                ", capacity=" + capacity +
                ", category=" + category +
                ", instructor=" + instructor +
                '}';
    }
}
