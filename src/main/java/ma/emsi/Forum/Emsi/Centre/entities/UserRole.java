package ma.emsi.Forum.Emsi.Centre.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
@Builder
public class UserRole {
    @Id
    @Column(nullable = false, updatable = false)
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<EmsiUser> users = new HashSet<>();
}
