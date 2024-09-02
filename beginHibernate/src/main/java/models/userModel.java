package models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class userModel implements Serializable {
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
    @CreationTimestamp
    @Temporal(TemporalType.DATE)  // Đảm bảo lưu cả ngày và giờ
    private Date createdDate;
    @UpdateTimestamp
    @Temporal(TemporalType.DATE)  // Đảm bảo lưu cả ngày và giờ
    private Date updatedDate;

    public userModel() {
    }

    public userModel(String id, String name, String address, String userName, String password, String telePhone, Boolean sex, String email, Date createdDate, Date updatedDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.userName = userName;
        this.password = password;
        this.telePhone = telePhone;
        this.sex = sex;
        this.email = email;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "userModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", telePhone='" + telePhone + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
