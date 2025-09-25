package Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
    @Id
    private String id;
    @Column(name = "b_name", length = 255, unique = true)
    private String name;
    @Column(name = "b_name", length = 255)
    private String author;
    private int totalStock;
    private int currentStock;

    public Book(String author, int currentStock, String id, String name, int totalStock) {
        this.author = author;
        this.currentStock = currentStock;
        this.id = id;
        this.name = name;
        this.totalStock = totalStock;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(int totalStock) {
        this.totalStock = totalStock;
    }
}
