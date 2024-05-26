package ma.emsi.Forum.Emsi.Centre.dao;

import ma.emsi.Forum.Emsi.Centre.entities.EmsiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmsiUserRepo extends JpaRepository<EmsiUser, Long> {
    EmsiUser findByUsername(String username);
}