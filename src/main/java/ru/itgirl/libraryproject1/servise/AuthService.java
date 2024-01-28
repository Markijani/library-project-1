package ru.itgirl.libraryproject1.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itgirl.libraryproject1.model.Role;
import ru.itgirl.libraryproject1.model.User;
import ru.itgirl.libraryproject1.repository.RoleRepository;
import ru.itgirl.libraryproject1.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public AuthService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public void register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findAll().get(0));
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }
}
