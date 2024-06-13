package rf.aleksper.diplomproject.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import rf.aleksper.diplomproject.entities.UserEntity;
import rf.aleksper.diplomproject.repositories.UserRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity login = userRepository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("Пользователь " + username + " не найден."));
        return new User(login.getUsername(), login.getPassword(), List.of(
                new SimpleGrantedAuthority(login.getRole())
        ));
    }
}
