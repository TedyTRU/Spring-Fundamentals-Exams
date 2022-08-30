package bg.softuni.mobilelele.init;

import bg.softuni.mobilelele.model.entity.*;
import bg.softuni.mobilelele.model.entity.enums.CategoryEnum;
import bg.softuni.mobilelele.repository.BrandRepository;
import bg.softuni.mobilelele.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DBInit(BrandRepository brandRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.brandRepository = brandRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        initializeBrandAndModels();
        initializeUsers();

    }

    private void initializeUsers() {

        if (userRepository.count() == 0) {
            User admin = new User();
            admin
                    .setActive(true)
                    .setEmail("admin")
                    .setFirstName("Admin")
                    .setLastName("Adminov")
                    .setPassword(passwordEncoder.encode("123"))
                    ;

            userRepository.save(admin);
        }

    }

    private void initializeBrandAndModels() {
        if (brandRepository.count() == 0) {
            Brand ford = new Brand().setName("Ford");

            Model fiesta = new Model();
            fiesta
                    .setName("Fiesta")
                    .setImageUrl("https://mediacloud.carbuyer.co.uk/image/private/s--MNoYm9aL--/v1605713681/carbuyer/2020/11/Ford%20Fiesta%202018%202019%20COTY.jpg")
                    .setStartYear(1976)
                    .setCategory(CategoryEnum.CAR);

            Model escort = new Model();
            escort
                    .setName("Escort")
                    .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/e/e9/1996_Ford_Escort_RS_Cosworth_2.0_Front.jpg")
                    .setStartYear(1968)
                    .setEndYear(2002)
                    .setCategory(CategoryEnum.CAR);

            ford.setModels(List.of(fiesta, escort));
            fiesta.setBrand(ford);
            escort.setBrand(ford);

            brandRepository.save(ford);
        }
    }

}
