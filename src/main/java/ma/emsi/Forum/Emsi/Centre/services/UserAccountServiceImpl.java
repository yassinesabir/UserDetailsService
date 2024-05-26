package ma.emsi.Forum.Emsi.Centre.services;

import lombok.AllArgsConstructor;
import ma.emsi.Forum.Emsi.Centre.dao.EmsiUserRepo;
import ma.emsi.Forum.Emsi.Centre.dao.UserRoleRepo;
import ma.emsi.Forum.Emsi.Centre.entities.EmsiUser;
import ma.emsi.Forum.Emsi.Centre.entities.UserRole;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@Transactional
@AllArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {
    private EmsiUserRepo emsiUserRepo;
    private UserRoleRepo userRoleRepo;
    private PasswordEncoder passwordEncoder;
    @Override
    public EmsiUser addNewStudent(String firstname, String lastname, String username,String email, String password, String phone, String sector, String level, Integer usergroup) {
        EmsiUser student = emsiUserRepo.findByUsername(username);
        if(student != null) throw new RuntimeException("Student with username " + username + " already exists");
        student = EmsiUser.builder()
                .userid(UUID.randomUUID().toString())
                .firstname(firstname)
                .lastname(lastname)
                .username(username)
                .email(email)
                .password(passwordEncoder.encode(password))
                .phone(phone)
                .sector(sector)
                .level(level)
                .usergroup(usergroup)
                .build();

        return emsiUserRepo.save(student);
    }


    @Override
    public EmsiUser addNewTeacher(String firstname, String lastname, String username, String email, String password, String phone, String assignment) {
        EmsiUser teacher=emsiUserRepo.findByUsername(username);
        if(teacher != null) throw new RuntimeException("already exist");
        teacher=EmsiUser.builder()
                .userid(UUID.randomUUID().toString())
                .firstname(firstname)
                .lastname(lastname)
                .username(username)
                .email(email)
                .password(passwordEncoder.encode(password))
                .phone(phone)
                .assignment(assignment)
                .build();
        return emsiUserRepo.save(teacher);
    }

    @Override
    public EmsiUser addNewAdmin(String username, String email, String password, String phone) {
        EmsiUser admin=emsiUserRepo.findByUsername(username);
        if(admin != null) throw new RuntimeException("already exist");
        admin=EmsiUser.builder()
                .userid(UUID.randomUUID().toString())
                .username(username)
                .email(email)
                .password(passwordEncoder.encode(password))
                .phone(phone)
                .build();
        return emsiUserRepo.save(admin);
    }

    @Override
    public EmsiUser addNewSectorManager(String firstname, String lastname, String username, String email, String password, String phone, String assignment, String level) {
        EmsiUser sectorManager=emsiUserRepo.findByUsername(username);
        if(sectorManager != null) throw new RuntimeException("already exist");
        sectorManager=EmsiUser.builder()
                .userid(UUID.randomUUID().toString())
                .username(username)
                .firstname(firstname)
                .lastname(lastname)
                .email(email)
                .password(passwordEncoder.encode(password))
                .phone(phone)
                .assignment(assignment)
                .level(level)
                .build();
        return emsiUserRepo.save(sectorManager);
    }

    @Override
    public UserRole addNewRole(String role) {
        UserRole existingRole = userRoleRepo.findByRole(role);
        if (existingRole != null) throw new RuntimeException("This role already exists");
        UserRole newRole = UserRole.builder()
                .role(role)
                .build();

        return userRoleRepo.save(newRole);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        EmsiUser emsiUser = emsiUserRepo.findByUsername(username);
        UserRole userRole = userRoleRepo.findByRole(role);
        emsiUser.getRoles().add(userRole);
    }


    @Override
    public void deleteRoleFromUser(String username, String role) {
        EmsiUser emsiUser = emsiUserRepo.findByUsername(username);
        UserRole userRole = userRoleRepo.findByRole(role);
        emsiUser.getRoles().remove(userRole);
    }

    @Override
    public EmsiUser loadUserByUsername(String username) {
        return emsiUserRepo.findByUsername(username);
    }
}
