package Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    private String roll;
    @Column(name = "s_firstName", length = 255)
    private String firstName;
    @Column(name = "s_lastName", length = 255)
    private String lastName;
    @Column(name = "s_dept", length = 10)
    private String dept;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> allocatedBooks = new ArrayList<>();

    public Student(String dept, String firstName, String lastName, String roll) {
        this.dept = dept;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roll = roll;
    }

    public List<Book> getAllocatedBooks() {
        return allocatedBooks;
    }

    public void setAllocatedBooks(List<Book> allocatedBooks) {
        this.allocatedBooks = allocatedBooks;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
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

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }
}

