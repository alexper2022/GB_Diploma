package rf.aleksper.diplomproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity(name = "users")
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String password;
    private String role;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Date createdAt;
    private Date endAt;

    public UserEntity() {
        this.createdAt = new Timestamp(new Date().getTime());
        this.endAt = null;
    }

    public UserEntity(String user, String password, String role, String firstName, String lastName, String email, String phone) {
        this.username = user;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.email = email;
        this.phone = phone;
        this.createdAt = new Timestamp(new Date().getTime());
        this.endAt = null;
    }
}
