package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.entity.User;
import bg.softuni.mobilelele.model.service.UserLoginServiceModel;
import bg.softuni.mobilelele.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public boolean isLogin(UserLoginServiceModel userLoginServiceModel) {

        Optional<User> userEntityOpt = userRepository.findByUsername(userLoginServiceModel.getUsername());

        if (userEntityOpt.isEmpty()) {
            return false;
        } else {
            return passwordEncoder.matches(
                    userLoginServiceModel.getRowPassword(),
                    userEntityOpt.get().getPassword());
        }

//        //TODO
//        throw new UnsupportedOperationException("not Yet implemented");

    }

}
