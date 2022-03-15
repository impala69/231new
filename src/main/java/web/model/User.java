package web.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
//    @NotNull(message = "Поле с имененм не должно быть пустым")
//    @Size(min = 2, max = 30, message = "Имя должно содерать больше одного символа")
    private String name;
    @Column(name = "lastName")
//    @NotNull(message = "Поле с фамилией не должно быть пустым")
    private String lastName;
    @Column(name = "email")
//    @NotNull(message = "Поле с email не должно быть пустым")
    private String email;
    @Column(name = "phoneNumber")
    // @NotNull(message = "Поле с номером телефона не должно быть пустым")
    private String phoneNumber;

    public User(String name, String lastName, String email, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}