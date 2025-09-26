package Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    private String id;

    @Column(name = "b_name", length = 255, unique = true)
    private String name;

    @Column(name = "b_author", length = 255)
    private String author;

    @ManyToOne
    @JoinColumn(name = "roll")
    private Student student;


    public Book(String author, String id, String name, Student student) {
        this.author = author;
        this.id = id;
        this.name = name;
        this.student = student;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}