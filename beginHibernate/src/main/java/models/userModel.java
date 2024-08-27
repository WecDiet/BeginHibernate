package models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class userModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // tự động cấp id cho userID
    @Column(nullable = false) // Không cho dữ liệu null
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String telePhone;
    @Column(nullable = false)
    private Boolean sex;
    @Column(nullable = false)
    private String email;

    public userModel() {
    }

    public userModel(String id, String name, String address, String userName, String password, String telePhone, Boolean sex, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.userName = userName;
        this.password = password;
        this.telePhone = telePhone;
        this.sex = sex;
        this.email = email;
    }
//    @Id
//    @GeneratedValue
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelePhone() {
        return telePhone;
    }

    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
