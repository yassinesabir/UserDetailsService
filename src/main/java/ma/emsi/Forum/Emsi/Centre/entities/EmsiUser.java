package ma.emsi.Forum.Emsi.Centre.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Builder
public class EmsiUser {
    @Id
    @Column(nullable = false, unique = true)
    private String userid;

    @Column(nullable = true)
    private String firstname;

    @Column(nullable = true)
    private String lastname;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Username cannot be empty")
    private String username;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email cannot be empty")
    @Pattern(regexp = ".+@emsi-edu\\.ma$", message = "Email address must end with @emsi-edu.ma")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    private String password;

    private String phone;

    @Column(nullable = true)
    private String assignment;

    @Column(nullable = true)
    private String imagePath;

    @Column(nullable = true)
    private String sector;

    @Column(nullable = true)
    private String level;

    @Column(nullable = true)
    private Integer usergroup;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "role"))
    private Set<UserRole> roles = new HashSet<>();
}
