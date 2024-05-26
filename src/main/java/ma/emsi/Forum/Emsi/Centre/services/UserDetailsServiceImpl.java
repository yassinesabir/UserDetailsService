package ma.emsi.Forum.Emsi.Centre.services;

import lombok.AllArgsConstructor;
import ma.emsi.Forum.Emsi.Centre.entities.EmsiUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserAccountService userAccountService;

    public UserDetailsServiceImpl(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EmsiUser emsiUser = userAccountService.loadUserByUsername(username);
        if(emsiUser==null)throw new UsernameNotFoundException(String.format("User %s not found",username));
        String[] roles = emsiUser.getRoles().stream().map(u -> u.getRole()).toArray(String[]::new);
        UserDetails userDetails= User
                .withUsername(emsiUser.getUsername())
                .password(emsiUser.getPassword())
                .roles(roles)
                .build();
        return userDetails;
    }
}
