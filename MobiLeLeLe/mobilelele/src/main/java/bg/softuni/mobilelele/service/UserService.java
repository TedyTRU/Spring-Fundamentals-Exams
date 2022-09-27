package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.UserRegisterDto;
import bg.softuni.mobilelele.model.entity.User;
import bg.softuni.mobilelele.model.mapper.UserMapper;
import bg.softuni.mobilelele.repository.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final UserDetailsService userDetailsService;
    private final EmailService emailService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper, UserDetailsService userDetailsService, EmailService emailService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.userDetailsService = userDetailsService;
        this.emailService = emailService;
    }

    private void login(User user) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());

        Authentication auth = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    public void registerAndLogin(UserRegisterDto userRegisterDto,
                                 Locale preferredLocale) {

//        User newUser = new User();
//        newUser.setActive(true);
//        newUser.setEmail(userRegisterDto.getEmail());
//        newUser.setFirstName(userRegisterDto.getFirstName());
//        newUser.setLastName(userRegisterDto.getLastName());
//        newUser.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));

        User newUser = userMapper.userDtoToUserEntity(userRegisterDto);
        newUser.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));

        //newUser = userRepository.save(newUser);
        userRepository.save(newUser);

        login(newUser);
        emailService.sendRegistrationEmail(newUser.getEmail(),
                newUser.getFirstName() + " " + newUser.getLastName(), preferredLocale);
    }

    public void initUsers() {

        if (userRepository.count() != 0) {
            return;
        }

        List<User> users = new ArrayList<>();

        users
                .add(new User()
                        .setEmail("lachezar.balev@gmail.com")
                        .setFirstName("Lucho")
                        .setLastName("Balev")
                        .setImageUrl(null)
                        .setActive(true)
                        .setPassword("topsecret"));
        users
                .add(new User()
                        .setEmail("example@example.com")
                        .setFirstName("example")
                        .setLastName("exampalov")
                        .setActive(false)
                        .setPassword("topsecret"));

        userRepository.saveAll(users);
    }
}
