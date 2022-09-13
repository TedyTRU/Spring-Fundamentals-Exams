package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.UserRegisterDto;
import bg.softuni.mobilelele.model.entity.User;
import bg.softuni.mobilelele.model.mapper.UserMapper;
import bg.softuni.mobilelele.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    private void login(User user) {
        // TO DO
    }


    public void registerAndLogin(UserRegisterDto userRegisterDto) {

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

    }

}
