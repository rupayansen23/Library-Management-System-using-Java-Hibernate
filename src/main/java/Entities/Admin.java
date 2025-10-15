package Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @Column(name = "ad_uerName", length = 255, nullable = false)
    private String userName;
    @Column(name = "ad_password", length = 255, nullable = false)
    private String password;

    public Admin() {

    }
    public Admin(String password, String userName) {
        this.password = password;
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}
