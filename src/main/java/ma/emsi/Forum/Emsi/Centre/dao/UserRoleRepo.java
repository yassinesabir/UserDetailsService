package ma.emsi.Forum.Emsi.Centre.dao;

import ma.emsi.Forum.Emsi.Centre.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Long> {
    UserRole findByRole(String role);
}