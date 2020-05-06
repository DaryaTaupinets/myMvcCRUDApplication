package web.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Byte age;

    private String email;

    private String location;

    private String password;

    private String role;

    public User() {
    }

    public User(Integer id, String name, Byte age, String email, String location) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.location = location;
    }

    public User(String name, Byte age, String email, String location) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.location = location;
    }

    public User(String name, Byte age, String email, String location, String password, String role) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.location = location;
        this.password = password;
        this.role = role;
    }

    public User(Integer id, String name, Byte age, String email, String location, String password, String role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.location = location;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(age, user.age) &&
                Objects.equals(email, user.email) &&
                Objects.equals(location, user.location) &&
                Objects.equals(password, user.password) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, email, location, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}